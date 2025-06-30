package com.example.demo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;

import java.time.LocalDate;

@Entity
@Table
public class Lending {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int LendingId;

    @ManyToOne
    @JoinColumn(name = "customerId")
    Customer customer;

    @ManyToOne
    @JoinColumn(name = "bookId")
    Book book;

    LocalDate lendingDate;
    Boolean returned;

    public Lending() {
    }

    public Lending(Customer customer, Book book, LocalDate lendingDate, Boolean returned) {
        this.customer = customer;
        this.book = book;
        this.lendingDate = lendingDate;
        this.returned = returned;
    }

    public int getLendingId() {
        return LendingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getLendingDate() {
        return lendingDate;
    }

    public Boolean getReturned() {
        return returned;
    }

    public void setLendingId(int lendingId) {
        LendingId = lendingId;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }
}
