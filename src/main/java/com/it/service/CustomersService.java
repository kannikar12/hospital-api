package com.it.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.dto.CustomersDto;
import com.it.entity.CustomersEntity;
import com.it.repository.CustomersRepository;
import com.it.utils.PasswordEncryptorUtils;

@Service
public class CustomersService {

	@Autowired
	private ModelMapper modelMapper;
	
	private final CustomersRepository customersRepository;

    CustomersService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }
	
	public List<CustomersRepository> findAllCustomers() {
		List<CustomersEntity> customersEntities = customersRepository.findAll();
		return modelMapper.map(customersEntities, new TypeToken<List<CustomersDto>>() {
		}.getType());
	}

	public CustomersDto findCustomersByCustId (Integer custId) {
		Optional<CustomersEntity> provinceOtn = customersRepository.findById(custId);
		if (provinceOtn.isPresent()) {
			CustomersDto dto = new CustomersDto();
			dto.setCustId(provinceOtn.get().getCustId());
			dto.setCustUsername(provinceOtn.get().getCustUsername());
			dto.setCustPassword(provinceOtn.get().getCustPassword());
			dto.setCustTitleType(provinceOtn.get().getCustTitleType());
			dto.setCustFistName(provinceOtn.get().getCustFistName());
			dto.setCustLastName(provinceOtn.get().getCustLastName());
			dto.setCustGender(provinceOtn.get().getCustGender());
			dto.setCustCardId(provinceOtn.get().getCustCardId());
			dto.setCustEmail(provinceOtn.get().getCustEmail());
			dto.setCustTelephone(provinceOtn.get().getCustTelephone());
			dto.setCustAddress(provinceOtn.get().getCustAddress());
			dto.setCustStatus(provinceOtn.get().getCustStatus());
			dto.setCustBirthDate(provinceOtn.get().getCustBirthDate());
			dto.setSdtId(provinceOtn.get().getSdtId());
			dto.setSdtZipCode(provinceOtn.get().getSdtZipCode());
			dto.setRoleId(provinceOtn.get().getRoleId());
			return dto;
		}

		return null;
	}

	public List<CustomersDto> findCustomersByRoleId (Integer roleId) {
		List<CustomersEntity> usersOtn = customersRepository.findByRoleId(roleId);
		if (usersOtn != null) {
			return usersOtn.stream().map(entity -> {
			CustomersDto dto = new CustomersDto();
			dto.setCustId(entity.getCustId());
			dto.setCustUsername(entity.getCustUsername());
			dto.setCustPassword(entity.getCustPassword());
			dto.setCustTitleType(entity.getCustTitleType());
			dto.setCustFistName(entity.getCustFistName());
			dto.setCustLastName(entity.getCustLastName());
			dto.setCustGender(entity.getCustGender());
			dto.setCustCardId(entity.getCustCardId());
			dto.setCustEmail(entity.getCustEmail());
			dto.setCustTelephone(entity.getCustTelephone());
			dto.setCustAddress(entity.getCustAddress());
			dto.setCustStatus(entity.getCustStatus());
			dto.setCustBirthDate(entity.getCustBirthDate());
			dto.setSdtId(entity.getSdtId());
			dto.setSdtZipCode(entity.getSdtZipCode());
			dto.setRoleId(entity.getRoleId());
			
			return dto;
		}).collect(Collectors.toList());

	}

	return null;
}
	
	public boolean saveCustomers(CustomersDto customersDto) {
		boolean saveFig = false;
		try {
			CustomersEntity entity = modelMapper.map(customersDto, CustomersEntity.class);
		  customersRepository.save(entity);
			saveFig = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFig;
	}

//	public boolean updateCustomers(Integer custId, CustomersDto customersDto) {
//		boolean updateFig = false;
//		try {
//			//
//			Optional<CustomersEntity> provinceOtn = customersRepository.findById( custId);
//			if (provinceOtn.isPresent()) {
//				 CustomersEntity  entity = modelMapper.map(customersDto, CustomersEntity.class);
//				customersRepository.save(entity);
//				updateFig = true;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return updateFig;
//	}

	public boolean updateCustomers(Integer userdtId, CustomersDto userDto) {
		boolean updateFig = false;
		try {
			//
			Optional<CustomersEntity> customersOtn = customersRepository.findById(userdtId);
			if (customersOtn.isPresent()) {
				CustomersEntity entity = modelMapper.map(userDto, CustomersEntity.class);

				entity.setCustUsername(PasswordEncryptorUtils.passwordEncryptor(entity.getCustPassword()));
				customersRepository.save(entity);
				updateFig = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateFig;
	}

	public boolean deleteCustomersBycustId(Integer custId) {
		boolean deleteFig = false;
		try {
			customersRepository.deleteById(custId);
			deleteFig = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteFig;
	}
	
}
	