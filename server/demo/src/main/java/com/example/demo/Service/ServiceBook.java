package com.example.demo.Service;

import com.example.demo.Dto.BookDto;
import com.example.demo.Entity.Book;
import com.example.demo.Repository.RepositoryBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceBook implements Ibook {
    RepositoryBooks Rep;

    @Autowired
    public ServiceBook(RepositoryBooks rp) {
        Rep = rp;
    }
    public BookDto mapper(Book book)
    {
        return new BookDto(book.getBookId(), book.getAuthor(), book.getBookName(), book.getReleaseDate());
    }
    public Book mapper(BookDto book)
    {
        return new Book(book.getAuthor(), book.getBookName(),book.getReleaseDate(),null);
    }

    @Override
    public BookDto GetByCode(Integer code) {
        Book book=Rep.findById(code).orElse(null);
        if(book != null)
            return mapper(book);
        return null;
    }

    @Override
    public Boolean UpdateNameOfBook(Integer IdBook, String newName) {
        if(!Rep.existsById(IdBook))
            return false;
        Book book=Rep.findById(IdBook).orElse(null);
        assert book != null;
        book.setBookName(newName);
        Rep.save(book);
        return true;

    }

    @Override
    public Boolean AddBook(BookDto book) {
//        if(Rep.existsById(book.getIdBook()))
//            return false;
        Rep.save(mapper(book));
        return true;
    }

    @Override
    public List<BookDto> GetAllBooks() {
       List<Book> l= (List<Book>) Rep.findAll();
       List<BookDto> list=new ArrayList<>();
       l.forEach(x->list.add(mapper(x)));
       return list;
    }

    @Override
    public BookDto GetBooksByName(String name) {
        ArrayList<Book> books =(ArrayList<Book>) Rep.findAll();
        Book b1= books.stream().filter(b -> b.getBookName().equals(name)).findFirst().orElse(null);
        return mapper(b1);
    }

    @Override
    public List<BookDto> GetBooksByPublicationDate(int year) {
        List<Book> l= (List<Book>) Rep.findAll();
        List<BookDto> list=l.stream().filter(x->x.getReleaseDate().getYear()==year).map(this::mapper).toList();
     return list;
    }
}
