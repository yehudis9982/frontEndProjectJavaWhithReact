package com.example.demo.Service;

import com.example.demo.Dto.CostumerDto;
import com.example.demo.Entity.Customer;
import com.example.demo.Repository.RepositoryCostumers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceCostumer implements Icostumer {
    RepositoryCostumers rep;
@Autowired
    public ServiceCostumer(RepositoryCostumers rep) {
        this.rep = rep;
    }
    public CostumerDto mapper(Customer costumer)
    {
        return new CostumerDto(costumer);
    }
    public Customer mapper(CostumerDto costumer)
    {
        return new Customer(costumer.getCustomerId(),  costumer.getfName(), costumer.getlName(),costumer.getPhone(),null);
    }
    @Override
    public CostumerDto GetCostumerByTz(String tz) {
    if(!rep.existsById(tz))
        return null;
       Customer costumer= rep.findById(tz).orElse(null) ;
    return mapper(costumer);
    }

    @Override
    public boolean AddCostumer(CostumerDto costumer) {
        if(rep.existsById(costumer.getCustomerId()))
            return false;
        rep.save(mapper(costumer));
    return true;
    }

    @Override
    public List<CostumerDto> GetAllCostumers() {

    return ((List<Customer>)rep.findAll()).stream().map(this::mapper).toList();
    }
}
