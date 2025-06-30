package com.example.demo.Service;

import com.example.demo.Dto.BookDto;

import java.util.List;

public interface Ibook {
public BookDto GetByCode(Integer code);
public Boolean UpdateNameOfBook(  Integer IdBook,String newName);
public Boolean AddBook(BookDto book);
public List<BookDto> GetAllBooks();
public BookDto GetBooksByName(String name);
public List<BookDto> GetBooksByPublicationDate(int year);
}
