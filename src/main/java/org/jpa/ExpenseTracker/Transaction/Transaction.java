package org.jpa.ExpenseTracker.Transaction;

import jakarta.persistence.*;
import org.jpa.ExpenseTracker.Category.Category;
import org.jpa.ExpenseTracker.User.User;

import java.sql.Timestamp;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "t_id")
    int tId;

    @Column
    int price;

    @Column
    String type;

    @Column
    Timestamp date;

    @Column
    String note = null;

    @ManyToOne
    @JoinColumn(name = "uid")
    private User user;

    @ManyToOne
    @JoinColumn(name = "cid")
    private Category category;

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "tId=" + tId +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", note='" + note + '\'' +
                ", user=" + user +
                ", category=" + category +
                '}';
    }
}
