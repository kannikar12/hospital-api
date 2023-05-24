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

import com.it.dto.ServiceDetailDto;
import com.it.repository.ServiceDetailRepository;

import com.it.service.ServiceDetailService;

@RestController
public class ServiceDetailController {

	private static final ServiceDetailRepository ServiceDetailDto = null;
	@Autowired
	public ServiceDetailService serviceDetailService;

	@GetMapping("/ServiceDetail")
	public ResponseEntity<Object> getAllServiceDetail() {
		return ResponseEntity.ok(serviceDetailService.findAllServiceDetail());
	}

	@GetMapping("/serviceDetail/{serviceDetailId}")
	public ResponseEntity<Object> getBillorderByBillId(
			@PathVariable(name = "serviceDetailId") Integer serviceDetailId) {
		return ResponseEntity.ok(serviceDetailService.findroleByServiceDetailId(serviceDetailId));
	}

	@PostMapping("/serviceDetail/save")
	public ResponseEntity<Object> saverEntity(@RequestBody ServiceDetailDto serviceDetailDto) {
		return ResponseEntity.ok(serviceDetailService.saveServiceDetail(ServiceDetailDto));
	}

	@PutMapping("/ServiceDetailDto/update/{ServiceDetailId}")
	public ResponseEntity<Object> updateServiceDetailDto(
			@PathVariable(name = "serviceDetailId") Integer serviceDetailDtoId,
			@RequestBody ServiceDetailDto sDetailDto) {
		return ResponseEntity.ok(serviceDetailService.updateServiceDetail(serviceDetailDtoId, sDetailDto));
	}

	@DeleteMapping("/ServiceDetai/{ServiceDetailId}")
	public ResponseEntity<Object> deleteServiceDetailByserviceDetailId(
			@PathVariable(name = "serviceDetailId") Integer serviceDetailId) {
		return ResponseEntity.ok(serviceDetailService.deleteServiceDetailByserviceDetailId(serviceDetailId));
	}

}
