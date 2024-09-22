package com.bookservice.controller;

import com.bookservice.dto.RequestBookDTO;
import com.bookservice.dto.ResponseBookDTO;
import com.bookservice.entity.BookEntity;
import com.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/create")
    public ResponseEntity<List<ResponseBookDTO>> storeBookData(@RequestBody List<RequestBookDTO> requestBookDTO){
        List<ResponseBookDTO> addBooks = bookService.createBookData(requestBookDTO);
      return new ResponseEntity(addBooks, HttpStatus.CREATED);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<ResponseBookDTO> getBookById(@PathVariable(value = "bookId")Integer bookId){
        ResponseBookDTO getBook = bookService.getBookById(bookId);
        return new ResponseEntity<>(getBook,HttpStatus.OK);
    }
}
