package org.jpa.ExpenseTracker.Transaction;

import org.jpa.ExpenseTracker.ETService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {
    private final ETService ts;

    @Autowired
    public TransactionController(ETService ts){
        this.ts = ts;
    }

    @GetMapping("/{u_id}")
    public List<TransactionResponse> getUserTransactions(@PathVariable int u_id){
        return ts.getTransactions(u_id);
    }

//    @PostMapping("/new")
//    public String addNewCategory(@RequestBody Map<String, Object> payload) {
//        int uid = (int) payload.get("uid");
//        String category_name = (String) payload.get("category_name");
//        return ets.addCategory(uid, category_name);
//    }

}
