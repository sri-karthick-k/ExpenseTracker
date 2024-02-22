package org.jpa.ExpenseTracker.Category;

import org.jpa.ExpenseTracker.ETService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cat")
public class CategoryViewController {
    private final ETService ets;

    public CategoryViewController(ETService ets) {
        this.ets = ets;
    }

    @GetMapping("/{u_id}")
    public String getUserCategories(@PathVariable int u_id, Model model) {
        List<Category> categories = ets.getCategoryUser(u_id);
        model.addAttribute("categories", categories);
        return "category/userCategories";
    }

}
