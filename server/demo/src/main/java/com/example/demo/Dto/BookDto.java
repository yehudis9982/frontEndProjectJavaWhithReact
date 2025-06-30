package com.example.demo.Dto;

import java.time.LocalDate;

public class BookDto
{
    int bookId;
    String author;
    String bookName;
    LocalDate releaseDate;

    public BookDto(int bookId, String author, String bookName, LocalDate releaseDate) {
        this.bookId = bookId;
        this.author = author;
        this.bookName = bookName;
        this.releaseDate = releaseDate;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookId() {
        return bookId;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookName() {
        return bookName;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }



}

