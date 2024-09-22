package com.bookservice.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseBookDTO {
    private String bookName;
    private String authorName;
    private String description;
    private String publishCode;
    private Date createdAt;
}
