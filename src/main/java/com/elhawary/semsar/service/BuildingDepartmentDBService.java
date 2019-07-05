package com.elhawary.semsar.service;

import java.util.List;

import com.elhawary.semsar.model.BuildingDepartmentDB;

public interface BuildingDepartmentDBService {

	List<BuildingDepartmentDB> getAllBuildingDepartmentDB() ;
	
	BuildingDepartmentDB save(BuildingDepartmentDB buildingDepartmentDB) ;
	
	BuildingDepartmentDB update(BuildingDepartmentDB buildingDepartmentDB) ; 
	
	void delete(Long id) ;
	
	BuildingDepartmentDB getBuildingDepartmentDB(Long id) ;
}
