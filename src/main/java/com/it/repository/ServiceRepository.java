package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.ServiceEntity;

public interface ServiceRepository extends  JpaRepository<ServiceEntity, Integer>{

}
