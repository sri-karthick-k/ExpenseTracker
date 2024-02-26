package org.jpa.ExpenseTracker.Transaction;

import java.sql.Timestamp;

public class TransactionResponse {
    private int tId;
    private int price;
    private String type;
    private Timestamp date;
    private String note;
    private String categoryName; // Field for category name

    // Constructor
    public TransactionResponse(int tId, int price, String type, Timestamp date, String note, String categoryName) {
        this.tId = tId;
        this.price = price;
        this.type = type;
        this.date = date;
        this.note = note;
        this.categoryName = categoryName;
    }

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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}

