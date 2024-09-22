package com.publishservice.implementation;

import com.publishservice.dto.RequestPublishDTO;
import com.publishservice.dto.ResponsePublishDTO;
import com.publishservice.entity.PublishEntity;
import com.publishservice.repository.PublishRepository;
import com.publishservice.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PublishServiceImplementation implements PublishService {

    @Autowired
    PublishRepository publishRepository;
    @Override
    public List<ResponsePublishDTO> createData(List<RequestPublishDTO> requestPublishDTO) {

        List<ResponsePublishDTO> responsePublishDTOList = new ArrayList<>();

        requestPublishDTO.forEach(publishRecord -> {

            PublishEntity publishEntity = new PublishEntity();
            publishEntity.setPublisherName(publishRecord.getPublisherName());
            publishEntity.setIsPublished(publishRecord.getIsPublished());
            publishEntity.setPublishCode(publishRecord.getPublishCode());
            publishEntity.setPublishLocation(publishRecord.getPublishLocation());
            publishEntity.setPublishDate(publishRecord.getPublishDate());
            publishRepository.save(publishEntity);

            ResponsePublishDTO responsePublishDTO = new ResponsePublishDTO();
            responsePublishDTO.setPublisherName(publishEntity.getPublisherName());
            responsePublishDTO.setIsPublished(publishEntity.getIsPublished());
            responsePublishDTO.setPublishCode(publishEntity.getPublishCode());
            responsePublishDTO.setPublishLocation(publishEntity.getPublishLocation());
            responsePublishDTO.setPublishDate(publishEntity.getPublishDate());
            responsePublishDTOList.add(responsePublishDTO);
        });

        return responsePublishDTOList;
    }

    @Override
    public ResponsePublishDTO getPublishDataById(Integer publishId) {
       Optional<PublishEntity> publishEntity = publishRepository.findById(publishId);
       if(publishEntity.isEmpty())
           throw new NoSuchElementException("Record not found for ID : " +publishId);

        ResponsePublishDTO responsePublishDTO = new ResponsePublishDTO();
        responsePublishDTO.setPublisherName(publishEntity.get().getPublisherName());
        responsePublishDTO.setIsPublished(publishEntity.get().getIsPublished());
        responsePublishDTO.setPublishLocation(publishEntity.get().getPublishLocation());
        responsePublishDTO.setPublishCode(publishEntity.get().getPublishCode());
        responsePublishDTO.setPublishDate(publishEntity.get().getPublishDate());

        return responsePublishDTO;
    }
}
