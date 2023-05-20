package com.it.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.dto.ServiceDetailDto;
import com.it.dto.ServiceTypeDto;
import com.it.entity.ServiceDetailEntity;
import com.it.entity.ServiceTypeEntity;
import com.it.repository.ServiceDetailRepository;
import com.it.repository.ServiceTypeRepository;

@Service
public class ServiceTypeService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ServiceTypeRepository serviceTypeRepository;
	
	@Autowired
	private ServiceDetailRepository serviceDetailRepository;
	
	public List<ServiceTypeDto> findAllService() {
		List<ServiceTypeEntity> serviceEntities = serviceTypeRepository.findAll();
		return modelMapper.map(serviceEntities, new TypeToken<List<ServiceTypeDto>>() {
		}.getType());
	}
	
//	public ServiceTypeDto findroleByServiceId(Integer ServiceId) {
//		Optional<ServiceTypeEntity> rOptional = serviceTypeRepository.findById(ServiceId);
//		if (rOptional.isPresent()) {
//			ServiceTypeDto dto = new ServiceTypeDto();
//			dto.setServiceId(rOptional.get().getServiceId());
//			dto.setServiceName(rOptional.get().getServiceName());
//			dto.setServiceStatus(rOptional.get().getServiceStatus());
//			dto.setServiceDes(rOptional.get().getServiceDes());
//			
//			return  dto;
//		}
//
//		return null;
//	}
	
	public ServiceTypeDto findroleByServiceId(Integer ServiceId) {
		Optional<ServiceTypeEntity> rOptional = serviceTypeRepository.findById(ServiceId);
		if (rOptional.isPresent()) {
			ServiceTypeDto dto = new ServiceTypeDto();
			dto.setServiceId(rOptional.get().getServiceId());
			dto.setServiceName(rOptional.get().getServiceName());
			dto.setServiceStatus(rOptional.get().getServiceStatus());
			dto.setServiceDes(rOptional.get().getServiceDes());
			
			List<ServiceDetailEntity> stadiumDetailEntities = serviceDetailRepository.findByServiceId(rOptional.get().getServiceId());
			if (CollectionUtils.isNotEmpty(stadiumDetailEntities)) {
				dto.setServiceDetailDtos(modelMapper.map(stadiumDetailEntities, new TypeToken<List<ServiceDetailDto>>() {}.getType()));
			}
			// do...
			
			return  dto;
		}

		return null;
	}
	
	public boolean saveService( ServiceTypeDto serviceTypeDto) {
		boolean saveFig = false;
		try {
			ServiceTypeEntity entity = modelMapper.map(serviceTypeDto, ServiceTypeEntity.class);
			serviceTypeRepository.save(entity);
			saveFig = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFig;
	}
	
	public boolean updateService(Integer serviceId, ServiceTypeDto serviceTypeDto) {
		boolean updateFig = false;
		try {
		
			Optional<ServiceTypeEntity> roleOptional = serviceTypeRepository.findById(serviceId);
			if (roleOptional.isPresent()) {
				ServiceTypeEntity  entity = modelMapper.map(serviceTypeDto, ServiceTypeEntity.class);
				serviceTypeRepository.save(entity);
				updateFig = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateFig;
	}


	public boolean deleteServiceByserviceId(Integer serviceId) {
		boolean deleteFig = false;
		try {
			serviceTypeRepository.deleteById(serviceId);
			deleteFig = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteFig;
	}

}



