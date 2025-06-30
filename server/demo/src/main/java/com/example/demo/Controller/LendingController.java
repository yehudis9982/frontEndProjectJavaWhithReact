package com.example.demo.Controller;


import com.example.demo.Dto.LendingDto;
import com.example.demo.Entity.Lending;
import com.example.demo.Service.Ilending;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lending")
@CrossOrigin(origins = "http://localhost:3000")
public class LendingController {
    Ilending lendingService;
    @Autowired
    public LendingController(Ilending lendingService) {
        this.lendingService=lendingService;
    }
    @GetMapping("/getAllById/{id}")
    public List<LendingDto> getAll(@PathVariable String id){
        return lendingService.GetAllLendingsOfCustumer(id);
    }
    @PostMapping("/add")
    public boolean addLending(@RequestBody LendingDto l){
        return lendingService.addLending(l);
    }
@GetMapping("/getAll")
    public List<LendingDto> getAllLendings(){
        return lendingService.GetAllLendings();
}
    @GetMapping("/pay/{id}")
    public double pay (@PathVariable String id){
       return lendingService.pay(id);
    }
    @PutMapping("/returnBook/{id}")
    public boolean returnBook(@PathVariable int id){
       return lendingService.reaternBook((Integer) id);

    }


}

