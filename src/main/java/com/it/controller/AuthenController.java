package com.it.controller;

import org.apache.commons.lang3.ObjectUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.dto.AuthenDto;
import com.it.entity.CustomersEntity;
import com.it.repository.CustomersRepository;
import com.it.utils.PasswordEncryptorUtils;

@RequestMapping("/authentication")
@RestController
public class AuthenController {

	@Autowired 
	private CustomersRepository customersRepository;
	
	@PostMapping("/login")
	public  ResponseEntity<CustomersEntity> usernameByLoginPassword(@RequestBody AuthenDto request){
		 CustomersEntity entity = customersRepository.findBycustUsername(request.getUsername());
		 if (ObjectUtils.isNotEmpty(entity) && PasswordEncryptorUtils.checkPassword(request.getPassword(),entity.getCustPassword())) {
			 return ResponseEntity.ok(entity);
		 }else {
			return ResponseEntity.ok(entity);
			}
		 }
	}
	
	
