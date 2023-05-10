package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.AdiminEntity;

public interface AdminRepository extends JpaRepository<AdiminEntity, Integer> {

}
