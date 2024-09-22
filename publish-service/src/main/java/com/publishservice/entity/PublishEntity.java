package com.publishservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "publish_table")
public class PublishEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer publishId;

    @Column(name = "publisher_name")
    private String publisherName;

    @Column(name = "is_published")
    private Boolean isPublished;

    @Column(name = "publish_location")
    private String publishLocation;

    @Column(name = "publish_date")
    private Date publishDate;

    @Column(name = "publish_code")
    private String publishCode;
}
