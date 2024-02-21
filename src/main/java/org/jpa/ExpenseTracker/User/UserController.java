package org.jpa.ExpenseTracker.User;

import org.jpa.ExpenseTracker.ETService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final ETService ets;

    @Autowired
    public UserController(ETService ets){
        this.ets = ets;
    }

    @PostMapping ("/register")
    public int register(User request) {
        // return the username along with status code based on the returned code from register method
        return ets.register(request.getName(), request.getEmail(), request.getPassword());
    }

    @PostMapping("/login")
    public RedirectView login(User request) {
        int status = ets.login(request.getEmail(), request.getPassword());
        if (status == 1) {
            return new RedirectView("/user/dashboard");
        } else {
            return new RedirectView("/login?error=true");
        }
    }



}
