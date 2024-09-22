package com.publishservice.service;

import com.publishservice.dto.RequestPublishDTO;
import com.publishservice.dto.ResponsePublishDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PublishService {
    List<ResponsePublishDTO> createData(List<RequestPublishDTO> requestPublishDTO);

    ResponsePublishDTO getPublishDataById(Integer publishId);
}
