package com.example.demo.Controller;

import com.example.demo.Dto.BookDto;
import com.example.demo.Service.Ibook;
import org.apache.catalina.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {
    Ibook bookService;

    @Autowired
    public BookController(Ibook service) {
        bookService = service;
    }
    @GetMapping("/getAll")
    public List<BookDto> getAllBooks(){
        return bookService.GetAllBooks();
    }
    @PostMapping("/add")
    public boolean addBook(@RequestBody BookDto book){
        return bookService.AddBook(book);
    }
    @GetMapping("/getByIb/{id}")
    public BookDto getByCode(@PathVariable int id){return bookService.GetByCode(id);}
    @PutMapping("/update/{id}")
    public boolean updateBook(@RequestBody BookDto b,@PathVariable int id){
        return bookService.UpdateNameOfBook(id,b.getBookName());
    }
    @GetMapping("/getByPublishDate/{year}")
    public List<BookDto> getByPublishDate(@PathVariable int  year){
        return bookService.GetBooksByPublicationDate(year);
    }
    @GetMapping("/getByName/{name}")
    public BookDto getByName(@PathVariable String name){
        return bookService.GetBooksByName(name);
    }


}