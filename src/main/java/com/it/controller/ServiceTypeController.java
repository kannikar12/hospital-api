package com.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.it.dto.ServiceTypeDto;
import com.it.service.ServiceTypeService;

@RestController
public class ServiceTypeController {

	@Autowired
	public ServiceTypeService serviceTypeService;
	
	@GetMapping("/service")
	public ResponseEntity<Object> getAllService() {
		return ResponseEntity.ok(serviceTypeService.findAllService());
     }
	@GetMapping("/service/{serviceId}")
	public ResponseEntity<Object> getBillorderByBillId(@PathVariable(name = "serviceId") Integer serviceId) {
		return ResponseEntity.ok(serviceTypeService.findroleByServiceId(serviceId));
	}
	@PostMapping("/service/save")
	public ResponseEntity<Object> saverEntity(@RequestBody ServiceTypeDto serviceTypeDto) {
		return ResponseEntity.ok(serviceTypeService.saveService(serviceTypeDto));
	}
	@PutMapping("/service/update/{serviceId}")
	public ResponseEntity<Boolean> updateService(@PathVariable(name = "serviceId") Integer serviceId,
			@RequestBody ServiceTypeDto serviceTypeDto) {
		return ResponseEntity.ok(serviceTypeService.updateService(serviceId, serviceTypeDto));
	}

	@DeleteMapping("/service/{serviceId}")
	public ResponseEntity<Object> deleteRoleByroleId(@PathVariable(name = "serviceId") Integer serviceId) {
		return ResponseEntity.ok(serviceTypeService.deleteServiceByserviceId(serviceId));
	}

}

