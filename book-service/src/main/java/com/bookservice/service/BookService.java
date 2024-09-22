package com.bookservice.service;

import com.bookservice.dto.RequestBookDTO;
import com.bookservice.dto.ResponseBookDTO;

import java.util.List;

public interface BookService {
    List<ResponseBookDTO> createBookData(List<RequestBookDTO> requestBookDTO);

    ResponseBookDTO getBookById(Integer bookId);


}
