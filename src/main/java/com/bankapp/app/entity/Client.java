package com.bankapp.app.entity;

import com.bankapp.app.entity.enums.ClientStatus;
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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
        @Id
        @Column(name = "id")
        private int id;
        @ManyToOne(cascade = {MERGE, PERSIST, REFRESH})
        @JoinColumn(name = "manager_id")
        private Manager manager;
        @Column(name = "client_status")
        private ClientStatus status;
        @Column(name = "tax_code")
        private String taxCode;
        @Column(name = "first_name")
        private String firstName;
        @Column(name = "last_name")
        private String lastName;
        @Column(name = "email")
        private String email;
        @Column(name = "address")
        private String address;
        @Column(name = "phone")
        private String phone;
        @Column(name = "created_at")
        private LocalDate createdAt;
        @Column(name = "updated_at")
        private LocalDate updatedAt;

        @OneToMany(mappedBy = "client", fetch = FetchType.LAZY,
        orphanRemoval = true, cascade = {MERGE,PERSIST,REFRESH})
        private List<Account> accounts;


        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Client client = (Client) o;
                return id == client.id && Objects.equals(manager, client.manager) && status == client.status;
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, manager, status);
        }

        @Override
        public String toString() {
                return "Client{" +
                        "id=" + id +
                        ", manager=" + manager +
                        ", status=" + status +
                        ", taxCode='" + taxCode + '\'' +
                        ", firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", email='" + email + '\'' +
                        ", address='" + address + '\'' +
                        ", phone='" + phone + '\'' +
                        ", createdAt=" + createdAt +
                        ", updatedAt=" + updatedAt +
                        '}';
        }
}
