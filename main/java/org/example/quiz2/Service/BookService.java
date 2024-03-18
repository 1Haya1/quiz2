package org.example.quiz2.Service;

import org.example.quiz2.Model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookService {


    ArrayList<Book> books=new ArrayList<>();


    public ArrayList<Book>getAllBook(){
        return books;
    }


    public Book addBook(Book book){
        books.add(book);
        return book;
    }


    public Boolean UpdateBook(Integer id,Book book){
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getId()==id){
                books.set(i,book);
                return true;
            }
        }
        return false;
    }


    public Boolean deleteBook(Integer id){
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getId()==id){
                books.remove(i);
                return true;
            }
        }
        return false;
    }


    public Book searchBookName(String BookN) {
        for (Book book : books) {
            if (book.getName().equalsIgnoreCase(BookN)) {
                return book;
            }}
            return null;
        }

     public ArrayList<Book>getBookP(Integer numP){
        ArrayList<Book> bookP=new ArrayList<>();
         for(Book book:books){
             if(book.getNumPage()>=numP)
                 bookP.add(book);
         }
        return bookP;

    }}





