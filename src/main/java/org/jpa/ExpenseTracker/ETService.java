package org.jpa.ExpenseTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ETService {
    @Autowired
    UserRepo ur;

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
            System.out.println(u.name);
            System.out.println(u.email);
            System.out.println(u.password);
        }
        return users;
    }



}
