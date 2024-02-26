package org.jpa.ExpenseTracker.User;

import org.jpa.ExpenseTracker.ETService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

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
        if(status != -1){
            return new RedirectView("/cat/2");
        } else {
            return new RedirectView("/error");
        }
    }

//    @PostMapping("/login")
//    public int login(User request) {
//        return ets.login(request.getEmail(), request.getPassword());
//    }

    @PostMapping("/login")
    public Map<String, Integer> login(@RequestBody User request) {
        int userId = ets.login(request.getEmail(), request.getPassword());
        Map<String, Integer> response = new HashMap<>();
        response.put("userId", userId);
        return response;
    }



}
