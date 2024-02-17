package org.jpa.ExpenseTracker.Category;

import jakarta.persistence.*;
import org.jpa.ExpenseTracker.User.User;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "c_id")
    int cID;

    @Column
    String name;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
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

    public Category(int cID, String name) {
        this.cID = cID;
        this.name = name;
    }

    public Category(){}
}
