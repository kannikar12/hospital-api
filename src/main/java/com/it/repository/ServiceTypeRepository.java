package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.ServiceTypeEntity;

public interface ServiceTypeRepository extends JpaRepository<ServiceTypeEntity, Integer>{

}
