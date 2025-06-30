package com.example.demo.Controller;

import com.example.demo.Dto.CostumerDto;
import com.example.demo.Service.Ibook;
import com.example.demo.Service.Icostumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {
    Icostumer customerService;
    @Autowired
    public CustomerController(Icostumer service) {
        customerService = service;
    }
    @GetMapping("/getAll")
    public List<CostumerDto> getAll(){return customerService.GetAllCostumers();}
    @GetMapping("/getById/{id}")
    public CostumerDto getById(@PathVariable String id){return customerService.GetCostumerByTz(id);}
    @PostMapping("/add")
    public boolean addCustomer(@RequestBody CostumerDto c){return customerService.AddCostumer(c);}


}
