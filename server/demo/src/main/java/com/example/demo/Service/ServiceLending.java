package com.example.demo.Service;

import com.example.demo.Dto.LendingDto;
import com.example.demo.Entity.Book;
import com.example.demo.Entity.Customer;
import com.example.demo.Entity.Lending;
import com.example.demo.Repository.RepositoryBooks;
import com.example.demo.Repository.RepositoryCostumers;
import com.example.demo.Repository.RepositoryLendings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collector;

@Service
public class ServiceLending implements Ilending{
    RepositoryLendings rep;
    RepositoryBooks repositoryBooks;
    RepositoryCostumers repositoryCostumers;
    @Autowired
    public ServiceLending(RepositoryLendings rep, RepositoryBooks repositoryBooks, RepositoryCostumers repositoryCostumers) {
        this.rep = rep;
        this.repositoryBooks = repositoryBooks;
        this.repositoryCostumers = repositoryCostumers;
    }
    public LendingDto mapper(Lending lending)
    {
        return new LendingDto(lending);
    }
    public Lending mapper(LendingDto lendingDto) {
        Book book=repositoryBooks.findById(lendingDto.getBookId()).orElse(null);
        Customer costumer=repositoryCostumers.findById(lendingDto.getCustomerId()).orElse(null);
        assert costumer != null;
        return new Lending(costumer, book, lendingDto.getLendingDate(), null);
    }
    @Override
    public boolean addLending(LendingDto lending) {
       List<Lending> lendings= ((List<Lending>) rep.findAll()).stream().filter(l->l.getBook().getBookId()== lending.getBookId()&& !l.getReturned()).toList();
       if(!lendings.isEmpty())
           return false;
        rep.save(mapper(lending));
        return true;
    }

    @Override
    public Boolean reaternBook(Integer BorrowCode){
      Lending lending=rep.findById(BorrowCode).orElse(null);

        if(lending!=null)
      {
          lending.setReturned(true);
          rep.save(lending);
          return true;
      }
            return false;
    }

    @Override
    public List<LendingDto> GetAllLendingsOfCustumer(String Tz) {
        return (repositoryCostumers.findById(Tz).orElse(null).getLendings()).stream().map(this::mapper).toList();
    }

    @Override
    public List<LendingDto> GetAllLendings() {
        return ((List<Lending>)rep.findAll()).stream().map(this::mapper).toList();
    }
    public double pay(String id){
        List<LendingDto> myLendings= GetAllLendingsOfCustumer( id);

        double s= myLendings.stream().reduce(0.0,(sum,l)->{
            long days= ChronoUnit.DAYS.between(l.getLendingDate(), LocalDate.now());
            return sum + (days > 14 ? (days - 14) * 0.5 : 0);
        }, (sum1, sum2) -> sum1 + sum2);
        return s;
    }
}
