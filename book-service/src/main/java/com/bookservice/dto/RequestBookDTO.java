package com.bookservice.dto;

import jakarta.persistence.Column;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
@Data
public class RequestBookDTO {
    private String bookName;
    private String authorName;
    private String description;
    private String publishCode;
}
