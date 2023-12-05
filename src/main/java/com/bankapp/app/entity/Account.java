package com.bankapp.app.entity;

import com.bankapp.app.entity.enums.AccountStatus;
import com.bankapp.app.entity.enums.AccountType;
import com.bankapp.app.entity.enums.CurrencyCode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static jakarta.persistence.CascadeType.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @Column(name = "id")
    private int id;
    @ManyToOne(cascade = {MERGE, PERSIST, REFRESH})
    @JoinColumn(name = "client_id")   //binary
    private Client client;
    @Column(name ="account_name" )  //varchar(50)
    private String name;
    @Column(name = "account_type")   //varchar(30)
    private AccountType type;
    @Column(name = "account_status") //varchar(30)
    private AccountStatus status;
    @Column(name = "balance")          //numeric(15,2)
    private Double balance;
    @Column(name = "currency_code")     //varchar(3)
    private CurrencyCode currencyCode;

    @Column(name = "created_at")    //timestamp
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY,
            orphanRemoval = true, cascade = {MERGE, PERSIST, REFRESH})
    private List<Agreement> agreements;


    @OneToMany(mappedBy = "creditAccount", fetch = FetchType.LAZY,
    orphanRemoval = true, cascade = {MERGE,PERSIST,REFRESH})
    private List<Transaction> creditTransactions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id && Objects.equals(client, account.client) && Objects.equals(name, account.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, name);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", client=" + client +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", balance=" + balance +
                ", currencyCode=" + currencyCode +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}