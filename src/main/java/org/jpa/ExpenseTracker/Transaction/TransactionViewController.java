package org.jpa.ExpenseTracker.Transaction;

import org.jpa.ExpenseTracker.ETService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//@Controller
//@RequestMapping("/transactions")
//public class TransactionViewController {
//    @GetMapping("/transactions.html")
//    public String showTransactionsPage() {
//        return "transaction/transactions";
//    }
//}


@Controller
@RequestMapping("/transaction")
public class TransactionViewController {
    private final ETService ts;

    public TransactionViewController(ETService ts) {
        this.ts = ts;
    }

    @GetMapping("/{u_id}")
    public String getUserTransactions(@PathVariable int u_id, Model model) {
        List<TransactionResponse> transactions = ts.getTransactions(u_id);
        System.out.println(transactions.toString());
        model.addAttribute("transactions", transactions);
        return "transaction/transactions";
    }
}
