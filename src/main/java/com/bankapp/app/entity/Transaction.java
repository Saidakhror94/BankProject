package com.bankapp.app.entity;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @Column(name = "id")
    private int id;

@JoinColumn(name = "debit_account_id")
@ManyToOne
    private Account debitAccount;
@JoinColumn(name = "credit_account_id")
@ManyToOne
    private Account creditAccount;
    @Column(name = "transaction_type")
    private byte type;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "transaction_description")
    private String description;
    @Column(name = "created_at")
    private LocalDate createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id == that.id && Objects.equals(debitAccount, that.debitAccount) && Objects.equals(creditAccount, that.creditAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, debitAccount, creditAccount);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", debitAccount=" + debitAccount +
                ", creditAccount=" + creditAccount +
                ", type=" + type +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
