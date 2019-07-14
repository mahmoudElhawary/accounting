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
	private BuildingsRepository buildingsRepository;

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

	@Override
	public List<Buildings> findAllByUserRole(String role) {
		return buildingsRepository.findAllByUserRole(role);
	}

	@Override
	public List<Buildings> findAllByBuildingDepartmentBuildingDepartment(String department) {
		return buildingsRepository.findAllByBuildingDepartmentBuildingDepartment(department);
	}

	@Override
	public List<Buildings> findTop18ByOrderByCreatedDateDesc() {
		return buildingsRepository.findTop18ByOrderByCreatedDateDesc();
	}

	@Override
	public List<Buildings> findTop18ByOrderByBuildingContractCountDesc() {
		return buildingsRepository.findTop18ByOrderByBuildingContractCountDesc();
	}

	@Override
	public List<Buildings> findTop18ByOrderByBuildingSearchCountDesc() {
		return buildingsRepository.findTop18ByOrderByBuildingSearchCountDesc();
	}

	@Override
	public List<Buildings> findTop18ByOrderByBuildingCommentsCommentCountDesc() {
		return buildingsRepository.findTop18ByOrderByBuildingCommentsCommentCountDesc();
	}

	@Override
	public List<Buildings> findTop18ByOrderByBuildingRateDesc() {
		return buildingsRepository.findTop18ByOrderByBuildingRateDesc();
	}

	@Override
	public List<Buildings> findTop18ByOrderByBuildingViewDesc() {
		return buildingsRepository.findTop18ByOrderByBuildingViewDesc();
	}

	@Override
	public List<Buildings> findAllByUserId(Long id) {
		return buildingsRepository.findAllByUserId(id);
	}

}
