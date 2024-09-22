package com.publishservice.dto;

import lombok.Data;

import java.util.Date;
@Data
public class ResponsePublishDTO {
    private String publisherName;
    private Boolean isPublished;
    private String publishLocation;
    private Date publishDate;
    private String publishCode;
}
