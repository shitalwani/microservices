package com.publishservice.controller;

import com.publishservice.dto.RequestPublishDTO;
import com.publishservice.dto.ResponsePublishDTO;
import com.publishservice.entity.PublishEntity;
import com.publishservice.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publish")
public class PublishController {

        @Autowired
        PublishService publishService;

        @PostMapping("/create")
        public ResponseEntity<List<ResponsePublishDTO>> StorePublishData(@RequestBody List<RequestPublishDTO> requestPublishDTO){
        List<ResponsePublishDTO>  createData = publishService.createData(requestPublishDTO);
        return new ResponseEntity(createData, HttpStatus.CREATED);
        }

        @GetMapping("/getByID/{publishId}")
        public ResponseEntity<ResponsePublishDTO> getDataByPublishID(@PathVariable (name = "publishId") Integer publishId){
        ResponsePublishDTO getById = publishService.getPublishDataById(publishId);
        return new ResponseEntity<>(getById,HttpStatus.OK);

        }
}
