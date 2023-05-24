package com.it.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.dto.ServiceDetailDto;
import com.it.entity.ServiceDetailEntity;
import com.it.repository.ServiceDetailRepository;


@Service
public class ServiceDetailService{ 
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Autowired
	private ServiceDetailRepository serviceDetailRepository;

	private Object serviceDetailDto;
	
	public List<ServiceDetailDto> findAllServiceDetail() {
		List<ServiceDetailEntity> serviceDetailEntities = serviceDetailRepository.findAll();
		return modelMapper.map(serviceDetailEntities, new TypeToken<List<ServiceDetailDto>>() {
		}.getType());}
	
		public ServiceDetailDto findroleByServiceDetailId(Integer ServiceDetailId) {
			Optional<ServiceDetailEntity> rOptional = serviceDetailRepository.findById(ServiceDetailId);
			if (rOptional.isPresent()) {
				ServiceDetailDto dto = new ServiceDetailDto();
				dto.setServiceDetailId(rOptional.get().getServiceDetailId());
				dto.setServiceId(rOptional.get().getServiceId());
				dto.setServiceDetailStime(rOptional.get().getServiceDetailStime());
				dto.setServiceDetailEtime(rOptional.get().getServiceDetailEtime());
				
				List<ServiceDetailEntity> stadiumDetailEntities = serviceDetailRepository.findByServiceId(rOptional.get().getServiceId());
				if (CollectionUtils.isNotEmpty(stadiumDetailEntities)) {
					dto.setServiceDetailEtime(modelMapper.map(stadiumDetailEntities, new TypeToken<List<ServiceDetailDto>>() {}.getType()));
				}
				// do...
				
				return  dto;
			}

			return null;
		}
		
		public boolean saveServiceDetail(ServiceDetailRepository serviceDetailRepository) {
			boolean saveFig = false;
			try {
				ServiceDetailRepository entity = modelMapper.map(serviceDetailDto, ServiceDetailRepository.class);
				serviceDetailRepository.save(entity);
				saveFig = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return saveFig;
		}
		
		public boolean updateServiceDetail(Integer serviceDetailId, ServiceDetailDto serviceDetailDto) {
			boolean updateFig = false;
			try {
			
				Optional<ServiceDetailEntity> roleOptional = serviceDetailRepository.findById(serviceDetailId);
				if (roleOptional.isPresent()) {
					ServiceDetailEntity entity = modelMapper.map(serviceDetailDto, ServiceDetailEntity.class);
					serviceDetailDto.save(entity);
					updateFig = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return updateFig;
		}


		public boolean deleteServiceDetailByserviceDetailId(Integer serviceDetailId) {
			boolean deleteFig = false;
			try {
				serviceDetailRepository.deleteById(serviceDetailId);
				deleteFig = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return deleteFig;
		}


	}




	
	
