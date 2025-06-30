package com.example.demo.Service;

import com.example.demo.Dto.CostumerDto;

import java.util.List;

public interface Icostumer {
    public CostumerDto GetCostumerByTz(String tz);
    public boolean AddCostumer(CostumerDto costumer);
    public List<CostumerDto> GetAllCostumers();

}
