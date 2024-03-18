package org.example.quiz2.Controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.quiz2.Api.ApiResponse;
import org.example.quiz2.Model.Book;
import org.example.quiz2.Service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;



    @GetMapping("/get")
    public ResponseEntity getAllBook(){
        return ResponseEntity.status(200).body(bookService.getAllBook());
    }

    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody @Valid Book book, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        bookService.addBook(book);
        return ResponseEntity.status(200).body(bookService.addBook(book));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity UpdateBook(@PathVariable Integer id,Book book,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdate=bookService.UpdateBook(id,book);
        if(isUpdate){
            return ResponseEntity.status(200).body(new ApiResponse("updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id){
        if(bookService.deleteBook(id)==null){
            return ResponseEntity.status(400).body(new ApiResponse("not found"));
        }
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));
    }


    @GetMapping("/search/{BookN}")
    public ResponseEntity searchBookName(@PathVariable String BookN){
        if (bookService.searchBookName(BookN)==null){
            return ResponseEntity.status(400).body(new ApiResponse("not found"));
        }
        return ResponseEntity.status(200).body(bookService.searchBookName(BookN));
    }


    @GetMapping("/getallbook/{numP}")
    public ResponseEntity getBookP(@PathVariable Integer numP){
        return ResponseEntity.status(200).body(bookService.getBookP(numP));
    }




}
