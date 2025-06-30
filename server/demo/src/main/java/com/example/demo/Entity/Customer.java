package com.example.demo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;

import java.util.List;

@Entity
@Table
public class Customer {
    @Id
    @Column(length =9)
    String customerId;

    String fName;
    String lName;
    String phone;
    @OneToMany(mappedBy = "customer")
    List<Lending> lendings;

    public String getPhone() {
        return phone;
    }

    public List<Lending> getLendings() {
        return lendings;
    }

    public String getLastName() {
        return lName;
    }

    @NonNull
    public @Size(min = 9, max = 9) String getTz() {
        return customerId;
    }

    public String getFirstName() {
        return fName;
    }

    public Customer() {
    }

    public Customer(@NonNull String tzCustumer, String firstName, String lastName, String phone, List<Lending> lending) {
        customerId = tzCustumer;
        this.fName = firstName;
        lName = lastName;
        this.phone = phone;
        this.lendings = lending;
    }

    public Customer(@NonNull String tz, String firstName, String phone) {
        customerId = tz;
        fName = firstName;
       this. phone = phone;
    }
}
