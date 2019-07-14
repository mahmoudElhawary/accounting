package com.elhawary.semsar.service;

import java.util.List;

import com.elhawary.semsar.model.BuildingAddressDB;

public interface BuildingAddressDBService {

	List<BuildingAddressDB> getAllBuildingAddress();
	
	List<String> getAllMainGovernorate();

	List<String> getAllSubGovernorate();
	
	List<String> getAllNeighborhood();
	
	List<BuildingAddressDB> findAllByMainGovernorate(String mainGovernorate);
	
	List<BuildingAddressDB> findAllBySubGovernorate(String subGovernorate);
	
	List<BuildingAddressDB> findAllBySubGovernorateAndMainGovernorate(String subGovernorate , String mainGovernorate);
	
	BuildingAddressDB save(BuildingAddressDB category);
	
	BuildingAddressDB update(BuildingAddressDB category);
	
	void delete(Long categoryId);
	
	BuildingAddressDB getCategoryById(Long categoryId);
}
