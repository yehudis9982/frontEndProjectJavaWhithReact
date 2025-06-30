package com.example.demo.Repository;

import com.example.demo.Entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCostumers extends CrudRepository<Customer,String> {
}
