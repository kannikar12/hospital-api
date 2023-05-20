package com.it.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.CustomersEntity;

public interface CustomersRepository extends JpaRepository<CustomersEntity, Integer>{


	public List<CustomersEntity> findByRoleId(Integer roleId);

	public CustomersEntity findBycustUsername(String username);


}
