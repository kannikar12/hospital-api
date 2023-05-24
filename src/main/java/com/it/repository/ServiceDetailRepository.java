package com.it.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.ServiceDetailEntity;

public interface ServiceDetailRepository  extends JpaRepository<ServiceDetailEntity, Integer> {

	List<ServiceDetailEntity> findByServiceId(Integer serviceId);

	void save(ServiceDetailRepository entity);

}
