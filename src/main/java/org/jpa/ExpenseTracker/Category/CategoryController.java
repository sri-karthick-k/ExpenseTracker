package org.jpa.ExpenseTracker.Category;

import org.jpa.ExpenseTracker.ETService;
import org.jpa.ExpenseTracker.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final ETService ets;

    @Autowired
    public CategoryController(ETService ets){
        this.ets = ets;
    }

    @GetMapping("/{u_id}")
    public List<Category> getUserCategory(@PathVariable int u_id){
        return ets.getCategoryUser(u_id);
    }

    @PostMapping("/new")
    public String addNewCategory(@RequestBody Map<String, Object> payload) {
        int uid = (int) payload.get("uid");
        String category_name = (String) payload.get("category_name");
        return ets.addCategory(uid, category_name);
    }


}
