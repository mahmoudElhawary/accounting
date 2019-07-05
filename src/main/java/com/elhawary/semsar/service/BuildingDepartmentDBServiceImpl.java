package com.elhawary.semsar.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elhawary.semsar.model.BuildingDepartmentDB;
import com.elhawary.semsar.repository.BuildingDepartmentDBRepository;

@Service
public class BuildingDepartmentDBServiceImpl implements BuildingDepartmentDBService {

	@Autowired
	private BuildingDepartmentDBRepository departmentDBRepository ;
	
	@Override
	public List<BuildingDepartmentDB> getAllBuildingDepartmentDB() {
		return (List<BuildingDepartmentDB>) departmentDBRepository.findAll();
	}

	@Override
	public BuildingDepartmentDB save(BuildingDepartmentDB buildingDepartmentDB) {
		buildingDepartmentDB.setCreatedDate(new Date());
		return departmentDBRepository.save(buildingDepartmentDB);
	}

	@Override
	public BuildingDepartmentDB update(BuildingDepartmentDB buildingDepartmentDB) {
		buildingDepartmentDB.setUpdatedDate(new Date());
		return departmentDBRepository.save(buildingDepartmentDB);
	}

	@Override
	public void delete(Long id) {
		departmentDBRepository.deleteById(id);
	}

	@Override
	public BuildingDepartmentDB getBuildingDepartmentDB(Long id) {
		return departmentDBRepository.findById(id).get();
	}

}
