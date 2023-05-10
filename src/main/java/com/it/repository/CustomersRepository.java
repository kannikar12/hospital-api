package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.CustomersEntity;

public interface CustomersRepository extends JpaRepository<CustomersEntity, Integer>{

	public CustomersEntity findByCustUsername(String username);

}
