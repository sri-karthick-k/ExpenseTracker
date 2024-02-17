package org.jpa.ExpenseTracker.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
    @Query("SELECT new Category(c.cID, c.name) FROM Category c WHERE c.user.id = ?1")
    List<Category> findCategoryByUserId(int u_id);
}
