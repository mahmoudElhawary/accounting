package com.elhawary.semsar.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elhawary.semsar.model.Buildings;
import com.elhawary.semsar.repository.BuildingsRepository;

@Service
public class BuildingsServiceImpl implements BuildingsService {

	@Autowired
	private BuildingsRepository buildingsRepository ;
	@Override
	public List<Buildings> findAll() {
		return (List<Buildings>) buildingsRepository.findAll();
	}

	@Override
	public Buildings findById(Long id) {
		return buildingsRepository.findById(id).get();
	}

	@Override
	public Buildings saveBuildings(Buildings buildings) {
		buildings.setCreatedDate(new Date());
		return buildingsRepository.save(buildings);
	}

	@Override
	public Buildings updateBuildings(Buildings buildings) {
		buildings.setUpdatedDate(new Date());
		return buildingsRepository.save(buildings);
	}

	@Override
	public void deleteById(Long id) {
		buildingsRepository.deleteById(id);
	}

}
