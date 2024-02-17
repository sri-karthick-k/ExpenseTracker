package org.jpa.ExpenseTracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {
    @Query("SELECT name FROM User WHERE email = ?1")
    List<String> findByEmail(String email);

    @Query("SELECT name FROM User u WHERE u.email = ?1 and u.password = ?2")
    List<String> findByEmailAndPassword(String email, String password);
}
