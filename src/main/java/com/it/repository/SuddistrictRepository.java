package com.it.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.SuddistrictEntity;

public interface SuddistrictRepository extends JpaRepository<SuddistrictEntity, Integer>{

	List<SuddistrictEntity> findByZipCode(String zipCode);

}
