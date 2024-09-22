package com.publishservice.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;

@Data
public class RequestPublishDTO {
    private String publisherName;
    private Boolean isPublished;
    private String publishLocation;
    private Date publishDate;
    private String publishCode;
}
