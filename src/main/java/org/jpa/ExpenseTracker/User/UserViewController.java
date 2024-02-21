package org.jpa.ExpenseTracker.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


// UserController.java
@Controller
@RequestMapping("/user")
public class UserViewController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/register")
    public String registerForm() {
        return "user/register";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "user/login";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "index";
    }

    @GetMapping("/error")
    public String loginError(){
        return "user/login-error";
    }


}
