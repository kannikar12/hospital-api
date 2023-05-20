package com.it.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.it.dto.DistrictDto;
import com.it.dto.SuddistrictDto;
import com.it.entity.DistrictEntity;
import com.it.entity.SuddistrictEntity;
import com.it.repository.DistrictRepository;
import com.it.repository.SuddistrictRepository;
import com.it.service.SuddistrictService;

@RestController
public class SuddistrictController{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private SuddistrictRepository suddistrictRepository;
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private SuddistrictService suddistrictService;

	private SuddistrictDto convertToResponse(SuddistrictEntity entity) {
		SuddistrictDto response = new SuddistrictDto();
		if (ObjectUtils.isNotEmpty(entity)) {
			response = modelMapper.map(entity, SuddistrictDto.class);

			Optional<DistrictEntity> districtEntity = districtRepository.findById(entity.getDisId());
			if (districtEntity.isPresent()) {
				response.setDistrict(modelMapper.map(districtEntity.get(), DistrictDto.class));

			}
		}
		return response;

	}
	
	@GetMapping("/subdistrict/by_zip_code")
	public ResponseEntity<SuddistrictDto> getSubdistrictByZipCode(@RequestParam("zipCode") String zipCode) {
		List<SuddistrictEntity> entities = suddistrictRepository.findAll();
		if (CollectionUtils.isNotEmpty(entities)) {
			Optional<SuddistrictEntity> response = entities.stream()
					.filter(entity -> entity.getZipCode().equalsIgnoreCase(zipCode)).findFirst();
			if (response.isPresent()) {
				return ResponseEntity.ok(this.convertToResponse(response.get()));
			} else {
				return ResponseEntity.badRequest().body(null);
			}

		} else {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@GetMapping("/subdistrict/zipCode")
	public ResponseEntity<List<SuddistrictDto>> getAllSubdistrictByZipCode(@RequestParam("zipCode") String zipCode) {
		List<SuddistrictDto> response = new ArrayList<>();
		List<SuddistrictEntity> entities = suddistrictRepository.findByZipCode(zipCode);
		if (CollectionUtils.isNotEmpty(entities)) {
			response = entities.stream().map(this::convertToResponse).collect(Collectors.toList());
		}
		return ResponseEntity.ok(response);
	}
	
	
	
	
	
	@GetMapping("/suddistrict")
	public ResponseEntity<Object> getAllSuddistrict() {
		return ResponseEntity.ok(suddistrictService.findAllSuddistrict());
	}

	@GetMapping("/suddistrict/{disId}")
	public ResponseEntity<Object> getBillorderByBillId(@PathVariable(name = "sdtId") Integer sdtId) {
		return ResponseEntity.ok(suddistrictService.findSuddistrictBySdtId(sdtId));
	}

	@PostMapping("/suddistrict/save")
	public ResponseEntity<Object> saveSuddistrict(@RequestBody SuddistrictDto suddistrictDto) {
		return ResponseEntity.ok(suddistrictService.saveSuddistric(suddistrictDto));
	}

	@PutMapping("/suddistrict/update/{sdtId}")
	public ResponseEntity<Object> updateSuddistrict(@PathVariable(name = "sdtId") Integer sdtId,
			@RequestBody SuddistrictDto suddistrictDto) {
		return ResponseEntity.ok(suddistrictService.updateSuddistrict (sdtId,suddistrictDto));
	}

	@DeleteMapping("/suddistrict/{sdtId}")
	public ResponseEntity<Object> deleteSuddistrictBySdtId(@PathVariable(name = "sdtId") Integer sdtId) {
		return ResponseEntity.ok(suddistrictService.deleteSuddistrictBySdtId(sdtId));
	}
}