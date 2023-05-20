package com.it.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.dto.DistrictDto;
import com.it.entity.DistrictEntity;
import com.it.repository.DistrictRepository;


@Service
public class DistrictService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private DistrictRepository districtRepository;
	
	public List<DistrictDto> findAllDistrict() {
		return modelMapper.map(districtRepository, new TypeToken<List<DistrictEntity>>() {
		}.getType());
	}

	public DistrictDto  findDistrictByDisId (Integer disId) {
		Optional<DistrictEntity> provinceOtn = districtRepository.findById(disId);
		if (provinceOtn.isPresent()) {
			DistrictDto dto = new DistrictDto();
			dto.setDisId(provinceOtn.get().getDisId());
			dto.setDisCode(provinceOtn.get().getDisCode());
			dto.setDisNameTh(provinceOtn.get().getDisNameTh());
			dto.setDisNameEn(provinceOtn.get().getDisNameEn());
			dto.setDisId(provinceOtn.get().getDisId());
			
			return dto;
		}

		return null;
	}

	public boolean saveDistrict(DistrictDto districtDto) {
		boolean saveFig = false;
		try {
			DistrictEntity entity = modelMapper.map(districtDto, DistrictEntity.class);
		  districtRepository.save(entity);
			saveFig = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFig;
	}

	public boolean updateDistrict(Integer disId, DistrictDto districtDto) {
		boolean updateFig = false;
		try {
			//
			Optional<DistrictEntity> provinceOtn = districtRepository.findById(disId);
			if (provinceOtn.isPresent()) {
				DistrictEntity entity = modelMapper.map(districtDto, DistrictEntity.class);
				districtRepository.save(entity);
				updateFig = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateFig;
	}


	public boolean deleteDistrictByDisId(Integer disId) {
		boolean deleteFig = false;
		try {
			districtRepository.deleteById(disId);
			deleteFig = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteFig;
	}
	
}