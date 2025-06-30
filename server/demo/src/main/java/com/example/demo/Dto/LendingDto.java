package com.example.demo.Dto;

import com.example.demo.Entity.Lending;
import jakarta.validation.constraints.Null;

import java.time.LocalDate;

public class LendingDto {
    int LendingId;
    String customerName;
    String customerId;
    int bookId;
    LocalDate lendingDate;
    Boolean returned;

    public LendingDto() {
    }

    public LendingDto(int lendingId, String customerId, int bookId, LocalDate lendingDate) {
        LendingId = lendingId;
        this.customerId = customerId;
        this.bookId = bookId;
        this.lendingDate = lendingDate;
        this.returned = null;
    }
    public LendingDto(int lendingId, String customerName, String customerId, int bookId, LocalDate lendingDate, Boolean returned) {
        LendingId = lendingId;
        this.customerName = customerName;
        this.customerId = customerId;
        this.bookId = bookId;
        this.lendingDate = lendingDate;
        this.returned = returned;
    }

    public int getLendingId() {
        return LendingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setReturned(Boolean returned) {
        this.returned = true;
    }

    public LocalDate getLendingDate() {
        return lendingDate;
    }

    public Boolean getReturned() {
        return returned;
    }
public LendingDto(Lending lending) {
     LendingId=lending.getLendingId();
     customerName=lending.getCustomer().getFirstName();
    customerId=lending.getCustomer().getTz();
     bookId=lending.getBook().getBookId();
     lendingDate=lending.getLendingDate();
     returned=lending.getReturned();
    }
}