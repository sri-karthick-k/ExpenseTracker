package org.jpa.ExpenseTracker;

import org.jpa.ExpenseTracker.Category.*;
import org.jpa.ExpenseTracker.User.User;
import org.jpa.ExpenseTracker.User.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ETService {
    @Autowired
    UserRepo ur;
//    CategoryRepo cr;

    private final CategoryRepo cr;

    @Autowired
    public ETService(CategoryRepo cr) {
        this.cr = cr;
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
            User u = new User();
            u.setId(u_id);
            Category newCategory = new Category(c_name, u);
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


}
