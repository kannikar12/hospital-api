package com.it.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.dto.ProvinceDto;
import com.it.entity.ProvinceEntity;
import com.it.repository.ProvinceRepository;

@Service
public class ProvinceService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ProvinceRepository provinceRepository;
	
//	get All -> ดึงข้อมูลทั้งหมด
	public List<ProvinceDto> findAllProvince() {
		List<ProvinceEntity> provinceEntities = provinceRepository.findAll();
		return modelMapper.map(provinceEntities, new TypeToken<List<ProvinceDto>>() {
		}.getType());
	}

//	get by Id -> ดึงข้อมูลมาโชว์ทีละรายการ
	public ProvinceDto findProvinceByPvnId(Integer pvnId) {
		Optional<ProvinceEntity> provinceOtn = provinceRepository.findById(pvnId);
		if (provinceOtn.isPresent()) {
			ProvinceDto dto = new ProvinceDto();
			dto.setPvnId(provinceOtn.get().getPvnId());
			dto.setPvnCode(provinceOtn.get().getPvnCode());
			dto.setPvnNameTh(provinceOtn.get().getPvnNameTh());
			dto.setPvnNameEng(provinceOtn.get().getPvnNameEng());
			dto.setPvnArea(provinceOtn.get().getPvnArea());
			// do...
			return dto;
		}

		return null;
	}

//	post -> บันทึกข้อมูล
	public boolean saveProvince(ProvinceDto provinceDto) {
		boolean saveFig = false;
		try {
			ProvinceEntity entity = modelMapper.map(provinceDto, ProvinceEntity.class);
			provinceRepository.save(entity);
			saveFig = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFig;
	}

//	 put by Id -> แก้ไขข้อมูล
	public boolean updateProvince(Integer pvnId, ProvinceDto provinceDto) {
		boolean updateFig = false;
		try {
			//
			Optional<ProvinceEntity> provinceOtn = provinceRepository.findById(pvnId);
			if (provinceOtn.isPresent()) {
				ProvinceEntity entity = modelMapper.map(provinceDto, ProvinceEntity.class);
				provinceRepository.save(entity);
				updateFig = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateFig;
	}


//	 delete by Id -> ลบข้อมูลทีละรายการ
	public boolean deleteProvinceByPvnId(Integer pvnId) {
		boolean deleteFig = false;
		try {
			provinceRepository.deleteById(pvnId);
			deleteFig = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteFig;
	}
	
}//end
