package com.it.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.dto.SuddistrictDto;
import com.it.entity.SuddistrictEntity;
import com.it.repository.SuddistrictRepository;

@Service
public class SuddistrictService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private SuddistrictRepository suddistrictRepository;
	
	public List<SuddistrictDto> findAllSuddistrict() {
		List<SuddistrictEntity> suddistrictEntities = suddistrictRepository.findAll();
		return modelMapper.map(suddistrictEntities, new TypeToken<List<SuddistrictDto>>() {
		}.getType());
	}

	public SuddistrictDto findSuddistrictBySdtId (Integer sdtId) {
		Optional<SuddistrictEntity> provinceOtn = suddistrictRepository.findById(sdtId);
		if (provinceOtn.isPresent()) {
			SuddistrictDto dto = new SuddistrictDto();
			dto.setSdtId(provinceOtn.get().getSdtId());
			dto.setZipCode(provinceOtn.get().getZipCode());
			dto.setSdtNameTh(provinceOtn.get().getSdtNameTh());
			dto.setSdtNameEng(provinceOtn.get().getSdtNameEng());
			dto.setDisId(provinceOtn.get().getDisId());
			
			return dto;
		}

		return null;
	}

	public boolean saveSuddistric(SuddistrictDto suddistrictDto) {
		boolean saveFig = false;
		try {
			SuddistrictEntity entity = modelMapper.map(suddistrictDto, SuddistrictEntity.class);
		   suddistrictRepository.save(entity);
			saveFig = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFig;
	}

	public boolean updateSuddistrict(Integer sdtId, SuddistrictDto suddistrictDto) {
		boolean updateFig = false;
		try {
			//
			Optional<SuddistrictEntity> provinceOtn = suddistrictRepository.findById(sdtId);
			if (provinceOtn.isPresent()) {
				SuddistrictEntity entity = modelMapper.map(suddistrictDto, SuddistrictEntity.class);
				suddistrictRepository.save(entity);
				updateFig = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateFig;
	}


	public boolean deleteSuddistrictBySdtId(Integer sdtId) {
		boolean deleteFig = false;
		try {
			suddistrictRepository.deleteById(sdtId);
			deleteFig = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteFig;
	}
	
}
	
	