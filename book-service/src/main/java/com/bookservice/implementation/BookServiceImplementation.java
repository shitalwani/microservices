package com.bookservice.implementation;

import com.bookservice.dto.RequestBookDTO;
import com.bookservice.dto.ResponseBookDTO;
import com.bookservice.entity.BookEntity;
import com.bookservice.repository.BookRepository;
import com.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookServiceImplementation implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<ResponseBookDTO> createBookData(List<RequestBookDTO> requestBookDTO) {
        List<ResponseBookDTO> responseBookDTOList = new ArrayList<>();

        requestBookDTO.forEach(bookRecord ->{

            BookEntity bookEntity = new BookEntity();
                bookEntity.setBookName(bookRecord.getBookName());
                bookEntity.setAuthorName(bookRecord.getAuthorName());
                bookEntity.setDescription(bookRecord.getDescription());
                bookEntity.setPublishCode(bookRecord.getPublishCode());
                bookRepository.save(bookEntity);

            ResponseBookDTO responseBookDTO = new ResponseBookDTO();
                responseBookDTO.setBookName(bookEntity.getBookName());
                responseBookDTO.setAuthorName(bookEntity.getAuthorName());
                responseBookDTO.setDescription(bookEntity.getDescription());
                responseBookDTO.setPublishCode(bookEntity.getPublishCode());
            responseBookDTOList.add(responseBookDTO);

        });

        return responseBookDTOList;

    }

    @Override
    public ResponseBookDTO getBookById(Integer bookId) {
        Optional<BookEntity> bookEntity = bookRepository.findById(bookId);
        if(bookEntity.isEmpty())
            throw new NoSuchElementException("record not found for id:" +bookId);

        ResponseBookDTO responseBookDTO = new ResponseBookDTO();
        responseBookDTO.setBookName(bookEntity.get().getBookName());
        responseBookDTO.setAuthorName(bookEntity.get().getAuthorName());
        responseBookDTO.setDescription(bookEntity.get().getDescription());
        responseBookDTO.setPublishCode(bookEntity.get().getPublishCode());
        responseBookDTO.setCreatedAt(bookEntity.get().getCreatedAt());
        return responseBookDTO;

    }
    public String getPublishList(){
        HttpHeaders headers = new HttpHeaders();
        headers.set

    }
}
