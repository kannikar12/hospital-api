package com.it.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.it.dto.CustomersDto;
import com.it.entity.CustomersEntity;
import com.it.service.CustomersService;

@RestController
@RequestMapping("/v1/custId")
public class CustomersController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CustomersService customersServices;

	private CustomersDto convertToResponse(CustomersEntity entity) {
		CustomersDto response = modelMapper.map(entity, CustomersDto.class);
		return response;
	}

	@GetMapping("/customers")
	public ResponseEntity<Object> getAllCustomers() {
		return ResponseEntity.ok(customersServices.findAllCustomers());
	}

	@GetMapping("/custId")
	public ResponseEntity<CustomersDto> getCustomersBycudtId(@RequestParam("custId") Integer custId) {
		CustomersDto entity = customersServices.findCustomersByCustId(custId);
		if (entity.isPresent()) {
			return ResponseEntity.ok(this.convertToResponse(entity.get()));
		} else {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@GetMapping("/customers/{custId}")
	public ResponseEntity<Object> getBillorderByBillId(@PathVariable(name = "custId") Integer custId) {
		return ResponseEntity.ok(customersServices.findCustomersByCustId(custId));
	}

	@PostMapping("/customers/save")
	public ResponseEntity<Object> saveCustomers(@RequestBody CustomersDto customersDto) {
		return ResponseEntity.ok(customersServices.saveCustomers(customersDto));
	}

	@PutMapping("/customers/update/{custId}")
	public ResponseEntity<Object> updateCustomers(@PathVariable(name = "custId") Integer custId,
			@RequestBody CustomersDto customersDto) {
		return ResponseEntity.ok(customersServices.updateCustomers(custId, customersDto));
	}

	@DeleteMapping("/customers/{custId}")
	public ResponseEntity<Object> deleteCustomersByDisId(@PathVariable(name = "custId") Integer custId) {
		return ResponseEntity.ok(customersServices.deleteCustomersBycustId(custId));
	}
}
