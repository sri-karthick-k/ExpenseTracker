package org.jpa.ExpenseTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final ETService ets;

    @Autowired
    public UserController(ETService ets){
        this.ets = ets;
    }

    @PostMapping ("/register")
    public int register(@RequestBody User request) {
        return ets.register(request.getName(), request.getEmail(), request.getPassword());
    }

    @PostMapping("/login")
    public int login(@RequestBody User request) {
        return ets.login(request.getEmail(), request.getPassword());
    }

}
