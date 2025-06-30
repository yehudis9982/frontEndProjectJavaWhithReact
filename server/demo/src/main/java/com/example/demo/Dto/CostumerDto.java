package com.example.demo.Dto;

import com.example.demo.Entity.Customer;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

public class CostumerDto {
    String customerId;
    String fName;
    String lName;
    String phone;
    List<String> lendings;

    public CostumerDto() {
    }
    public CostumerDto(Customer costumer) {
        customerId = costumer.getTz();
        fName = costumer.getFirstName();
        lName = costumer.getLastName();
        phone = costumer.getPhone();
        List<String> l=new ArrayList<>();
        costumer.getLendings().forEach(x->l.add(x.getBook().getBookName()));
        this.lendings = l;
    }
    public CostumerDto(@NonNull String tzCustumer, String firstName, String lastName, String phone, List<String> lending) {
        customerId = tzCustumer;
       this.fName = firstName;
        this.lName = lastName;
        this.phone = phone;
        this.lendings = lending;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getLendings() {
        return lendings;
    }

    public void setLendings(List<String> lendings) {
        this.lendings = lendings;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }
}
