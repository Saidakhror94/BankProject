package com.bankapp.app.entity;

import com.bankapp.app.entity.enums.CurrencyCode;
import com.bankapp.app.entity.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "id")
    private int id;
    @JoinColumn(name = "manager_id")
    @ManyToOne
    private Manager manager;
    @Column(name = "product_name")
    private String name;
    @Column(name = "product_status")
    private ProductStatus status;
    @Column(name = "currency_code")
    private CurrencyCode currencyCode;
    @Column(name = "interest_rate")
    private Double interestRate;
    @Column(name = "product_limit")
    private int productLimit;
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Objects.equals(manager, product.manager) && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, manager, name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", manager=" + manager +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", currencyCode=" + currencyCode +
                ", interestRate=" + interestRate +
                ", productLimit=" + productLimit +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
