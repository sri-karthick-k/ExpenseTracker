//package org.jpa.ExpenseTracker;
//
////import org.jpa.ExpenseTracker.Transaction.Transaction;
////import org.jpa.ExpenseTracker.Transaction.TransactionRepo;
//import org.jpa.ExpenseTracker.User.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class TService {
//    @Autowired
//    TransactionRepo tr;
//
//
//    public List<Transaction> getTransactions(int u_id){
//        Transaction t = tr.findById(u_id).orElse(null);
//        User user = t.getUser();
//        if(user != null){
//            return tr.findTransactionsById(u_id);
//        }
//        return null;
//    }
//}
