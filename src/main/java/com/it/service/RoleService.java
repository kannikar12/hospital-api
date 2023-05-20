package com.it.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.dto.RoleDto;
import com.it.entity.RoleEntity;
import com.it.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public List<RoleDto> findAllRole() {
		List<RoleEntity> roleEntities = roleRepository.findAll();
		return modelMapper.map(roleEntities, new TypeToken<List<RoleDto>>() {
		}.getType());
	}


	public RoleDto findroleByRoleId(Integer roleId) {
		Optional<RoleEntity> rOptional = roleRepository.findById(roleId);
		if (rOptional.isPresent()) {
			RoleDto dto = new RoleDto();
			dto.setRoleId(rOptional.get().getRoleId());
			dto.setRoleName(rOptional.get().getRoleName());
			dto.setRoleDes(rOptional.get().getRoleDes());
			dto.setRoleStatus(rOptional.get().getRoleStatus());
			
			return dto;
		}

		return null;
	}
	
	public boolean saveRole( RoleDto roleDto) {
		boolean saveFig = false;
		try {
			RoleEntity entity = modelMapper.map(roleDto, RoleEntity.class);
			roleRepository.save(entity);
			saveFig = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFig;
	}

	public boolean updateRole(Integer roleId, RoleDto roleDto) {
		boolean updateFig = false;
		try {
			//
			Optional<RoleEntity> roleOptional = roleRepository.findById(roleId);
			if (roleOptional.isPresent()) {
				RoleEntity entity = modelMapper.map(roleRepository,RoleEntity.class);
				roleRepository.save(entity);
				updateFig = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateFig;
	}


	public boolean deleteRoleByroleId(Integer roleId) {
		boolean deleteFig = false;
		try {
			roleRepository.deleteById(roleId);
			deleteFig = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteFig;
	}


	}
	

