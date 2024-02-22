package org.jpa.ExpenseTracker.User;

import org.jpa.ExpenseTracker.ETService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public RedirectView register(User request) {
        int status = ets.register(request.getName(), request.getEmail(), request.getPassword());
        if(status == 1){
            return new RedirectView("/cat/2");
        } else {
            return new RedirectView("/error");
        }
    }

    @PostMapping("/login")
    public RedirectView login(User request) {
        int status = ets.login(request.getEmail(), request.getPassword());
        if (status == 1) {
            return new RedirectView("/cat/2");
        } else {
            return new RedirectView("/error");
        }
    }



}
