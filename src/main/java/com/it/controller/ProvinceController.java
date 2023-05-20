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

import com.it.dto.ProvinceDto;
import com.it.service.ProvinceService;

@RestController
public class ProvinceController
{

	@Autowired
	private ProvinceService provinceService;

	@GetMapping("/provinces")
	public ResponseEntity<Object> getAllProvince() {
		return ResponseEntity.ok(provinceService.findAllProvince());
	}

	@GetMapping("/provinces/{pvnId}")
	public ResponseEntity<Object> getBillorderByBillId(@PathVariable(name = "pvnId") Integer pvnId) {
		return ResponseEntity.ok(provinceService.findProvinceByPvnId(pvnId));
	}

	@PostMapping("/provinces/save")
	public ResponseEntity<Object> saveProvince(@RequestBody ProvinceDto provinceDTO) {
		return ResponseEntity.ok(provinceService.saveProvince(provinceDTO));
	}

	@PutMapping("/provinces/update/{pvnId}")
	public ResponseEntity<Object> updateProvince(@PathVariable(name = "pvnId") Integer pvnId,
			@RequestBody ProvinceDto proDto) {
		return ResponseEntity.ok(provinceService.updateProvince(pvnId, proDto));
	}

	@DeleteMapping("/provinces/{pvnId}")
	public ResponseEntity<Object> deleteProvincesByPvnId(@PathVariable(name = "pvnId") Integer pvnId) {
		return ResponseEntity.ok(provinceService.deleteProvinceByPvnId(pvnId));
	}

}
