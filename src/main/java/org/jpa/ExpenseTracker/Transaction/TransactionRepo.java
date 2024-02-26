package org.jpa.ExpenseTracker.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {
//    @Query("SELECT new Transaction(t.id, t.price, t.type, t.date, t.note, t.category) FROM Transaction t WHERE t.user.id = ?1")
//    @Query("SELECT t FROM Transaction t WHERE t.user.id = ?1")
//    List<Transaction> findTransactionsByUserId(int u_id);
    @Query("SELECT new org.jpa.ExpenseTracker.Transaction.TransactionResponse(t.tId, t.price, t.type, t.date, t.note, c.name) FROM Transaction t JOIN t.category c WHERE t.user.id = ?1")
    List<TransactionResponse> findTransactionsByUserId(int u_id);

}
