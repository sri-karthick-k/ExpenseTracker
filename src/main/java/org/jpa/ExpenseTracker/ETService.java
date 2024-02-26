package org.jpa.ExpenseTracker;

import org.jpa.ExpenseTracker.Category.*;
//import org.jpa.ExpenseTracker.Transaction.Transaction;
//import org.jpa.ExpenseTracker.Transaction.TransactionRepo;
import org.jpa.ExpenseTracker.Transaction.Transaction;
import org.jpa.ExpenseTracker.Transaction.TransactionRepo;
import org.jpa.ExpenseTracker.Transaction.TransactionResponse;
import org.jpa.ExpenseTracker.User.User;
import org.jpa.ExpenseTracker.User.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ETService {
    @Autowired
    UserRepo ur;

    private final CategoryRepo cr;
    private final TransactionRepo tr;

    @Autowired
    public ETService(CategoryRepo cr, TransactionRepo tr) {
        this.cr = cr;
        this.tr = tr;
    }

    public int register(String name, String email, String password){
        List<String> users = ur.findByEmail(email);
        if(!users.isEmpty()){
            return -1;
        }

        User u = new User(name, email, password);
        ur.save(u);
        return 1;
    }

    public int login(String email, String password){
        List<String> user = ur.findByEmail(email);
        if(!user.isEmpty()){
            List<String> matchedNames = ur.findByEmailAndPassword(email, password);
            if(!matchedNames.isEmpty()){
                // return username
                System.out.println(user.get(0));
                // Valid credentials
                return 1;
            } else {
                // Invalid credentials
                return -1;
            }
        } else {
            // email does not exist
            return -4;
        }
    }

    // @DELETE this temporary method
    public List<User> displayAll(){
        List<User> users = ur.findAll();
        for(User u : users){
            System.out.println(u.getName());
            System.out.println(u.getEmail());
            System.out.println(u.getPassword());
        }
        return users;
    }

    public String addCategory(int u_id, String c_name){
        User user = ur.findById(u_id).orElse(null);
        if(user != null){
            Category newCategory = new Category(c_name, user);
            cr.save(newCategory);
            return "SUCCESS";
        } else {
            return "USER NOT FOUND";
        }
    }
    public List<Category> getCategoryUser(int u_id){
        User user = ur.findById(u_id).orElse(null);
        if(user != null){
            return cr.findCategoryByUserId(u_id);
        }
        return null;
    }

    public List<TransactionResponse> getTransactions(int u_id){
        User user = ur.findById(u_id).orElse(null);

        if(user != null){
            System.out.println("user found " +user.getEmail());
            return tr.findTransactionsByUserId(u_id);
        }
        return null;
    }

    public String addNewTransaction(int u_id, int c_id, int price, String type, Timestamp date, String note){
        User user = ur.findById(u_id).orElse(null);
        Category category = cr.findById(c_id).orElse(null);

        if(user != null && category != null){
            Transaction t = new Transaction();
            t.setCategory(category);
            t.setUser(user);
            t.setDate(date);
            t.setPrice(price);
            t.setNote(note);
            t.setType(type);
            tr.save(t);
            return "Success";
        } else {
            return "Category or user not found!";
        }
    }

    public String deleteTransaction(int t_id){
        if(tr.findById(t_id).isPresent()){
            tr.deleteById(t_id);
            return "Deleted";
        } else
            return null;
    }


}
