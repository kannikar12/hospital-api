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

import com.it.dto.RoleDto;
import com.it.service.RoleService;

@RestController
public class RoleController {

	@Autowired
	public RoleService roleService;

	@GetMapping("/role")
	public ResponseEntity<Object> getAllRole() {
		return ResponseEntity.ok(roleService.findAllRole());
	}

	@GetMapping("/role/{roleId}")
	public ResponseEntity<Object> getBillorderByBillId(@PathVariable(name = "roleId") Integer roleId) {
		return ResponseEntity.ok(roleService.findroleByRoleId(roleId));
	}

	@PostMapping("/role/save")
	public ResponseEntity<Object> saverEntity(@RequestBody RoleDto roleDto) {
		return ResponseEntity.ok(roleService.saveRole(roleDto));
	}

	@PutMapping("/role/update/{roleId}")
	public ResponseEntity<Object> updateRole(@PathVariable(name = "roleId") Integer roleId,
			@RequestBody RoleDto roleDto) {
		return ResponseEntity.ok(roleService.updateRole(roleId, roleDto));
	}

	@DeleteMapping("/role/{roleId}")
	public ResponseEntity<Object> deleteRoleByroleId(@PathVariable(name = "roleId") Integer roleId) {
		return ResponseEntity.ok(roleService.deleteRoleByroleId(roleId));
	}

}
