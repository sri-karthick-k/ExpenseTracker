package org.jpa.ExpenseTracker.User;

import org.jpa.ExpenseTracker.ETService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


// UserController.java
@Controller
@RequestMapping("/user")
public class UserViewController {
    private final ETService ets;

    @Autowired
    public UserViewController(ETService ets){
        this.ets = ets;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/register")
    public String registerForm() {
        return "user/register";
    }

    @PostMapping("/register")
    public String register(@RequestBody User request) {
        int status = ets.register(request.getName(), request.getEmail(), request.getPassword());
        if(status == 1)
            return "redirect:/login";
        else
            return "redirect:/register?error=true";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@RequestBody User request) {
        int status = ets.login(request.getEmail(), request.getPassword());
        if(status == 1)
            return "redirect:/dashboard"; // Redirect to dashboard upon successful login
        else
            return "redirect:/login?error=true"; // Redirect to login page with error flag
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "index";
    }
}
