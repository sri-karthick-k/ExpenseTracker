package org.jpa.ExpenseTracker.Category;

import jakarta.persistence.*;
import org.jpa.ExpenseTracker.User;

@Entity
@Table(name = "category")
public class Category {
    @Id
    int id;

    @Column
    String name;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category(String name, User user) {
        this.name = name;
        this.user = user;
    }

    public Category(){}
}
