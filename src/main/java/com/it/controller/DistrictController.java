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

import com.it.dto.DistrictDto;
import com.it.service.DistrictService;

@RestController
public class  DistrictController {

	@Autowired
	private DistrictService districtService;

	@GetMapping("/ district")
	public ResponseEntity<Object> getAllDistrict() {
		return ResponseEntity.ok(districtService.findAllDistrict());
	}

	@GetMapping("/ district/{custId}")
	public ResponseEntity<Object> getBillorderByBillId(@PathVariable(name = "disId") Integer disId) {
		return ResponseEntity.ok(districtService.findDistrictByDisId(disId));
	}

	@PostMapping("/ district/save")
	public ResponseEntity<Object> saveDistrict(@RequestBody DistrictDto districtDto) {
		return ResponseEntity.ok(districtService.saveDistrict(districtDto));
	}

	@PutMapping("/ district/update/{disId}")
	public ResponseEntity<Object> updateDistrict(@PathVariable(name = "disId") Integer disId,
			@RequestBody DistrictDto districtDto) {
		return ResponseEntity.ok(districtService.updateDistrict(disId,districtDto));
	}

	@DeleteMapping("/ district/{disId}")
	public ResponseEntity<Object> deleteDistrictByDisId(@PathVariable(name = "disId") Integer disId) {
		return ResponseEntity.ok(districtService.deleteDistrictByDisId(disId));
	}
}


