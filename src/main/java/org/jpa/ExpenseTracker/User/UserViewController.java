package org.jpa.ExpenseTracker.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class UserViewController {

    @GetMapping("/")
    public String index() {
        return "user/login";
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
        return "category/userCategories";
    }

    @GetMapping("/error")
    public String loginError(){
        return "user/login-error";
    }


}
