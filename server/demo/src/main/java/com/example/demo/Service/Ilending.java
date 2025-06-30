package com.example.demo.Service;
import com.example.demo.Dto.LendingDto;

import java.util.List;
public interface Ilending {
    public boolean addLending(LendingDto lending);
    public Boolean reaternBook(Integer BorrowCode);
    public List<LendingDto> GetAllLendingsOfCustumer(String Tz);
    public List<LendingDto> GetAllLendings();
    double pay(String id);
}
