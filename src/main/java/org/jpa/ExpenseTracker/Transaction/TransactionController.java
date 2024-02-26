package org.jpa.ExpenseTracker.Transaction;

import org.jpa.ExpenseTracker.ETService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import java.sql.Timestamp;

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

    @PostMapping("/new")
    public ResponseEntity<String> addNewTransaction(@RequestBody Map<String, Object> payload) {
        try {
            // extracting foreign keys
            int uid = (int) payload.get("userId");
            int categoryId = (int) payload.get("categoryId");

            // extracting other fields of the transaction
            int price = (int) payload.get("price");
            String type = (String) payload.get("type");
            Timestamp date = Timestamp.valueOf((String) payload.get("date"));
            String note = (String) payload.get("note");

            String result = ts.addNewTransaction(uid, categoryId, price, type, date, note);

            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create transaction.");
        }
    }

    @DeleteMapping("/{t_id}")
    public String deleteTransaction(@PathVariable("t_id") int t_id) {
        return ts.deleteTransaction(t_id);
    }

}
