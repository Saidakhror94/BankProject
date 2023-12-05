package com.bankapp.app.entity;

import com.bankapp.app.entity.enums.AccountStatus;
import com.bankapp.app.entity.enums.AgreementStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.Objects;

import static jakarta.persistence.CascadeType.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "agreements")
public class Agreement {
    @Id
    @Column(name = "id")
    private int id;
    @ManyToOne(cascade = {MERGE, PERSIST, REFRESH})
    @JoinColumn(name = "account_id")
    private Account account;
    @JoinColumn(name = "product_id")
    @ManyToOne(cascade = {MERGE, PERSIST, REFRESH})
    private Product product;
    @Column(name = "account_status")
    private AccountStatus accountStatus;
    @Column(name = "interest_rate")
    private Double interestRate;
    @Column(name = "agreement_status")
    private AgreementStatus status;
    @Column(name = "agreement_sum")
    private Double sum;
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    private LocalDate updatedAt;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agreement agreement = (Agreement) o;
        return id == agreement.id && Objects.equals(account, agreement.account) && Objects.equals(product, agreement.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, product);
    }

    @Override
    public String toString() {
        return "Agreement{" +
                "id=" + id +
                ", account=" + account +
                ", product=" + product +
                ", accountStatus=" + accountStatus +
                ", interestRate=" + interestRate +
                ", status=" + status +
                ", sum=" + sum +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
