package com.publishservice.repository;

import com.publishservice.entity.PublishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishRepository extends JpaRepository<PublishEntity,Integer> {
}
