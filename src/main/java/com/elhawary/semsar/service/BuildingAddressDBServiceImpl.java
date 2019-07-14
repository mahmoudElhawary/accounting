package com.elhawary.semsar.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elhawary.semsar.model.BuildingAddressDB;
import com.elhawary.semsar.repository.BuildingAddressDBRepository;

@Service
public class BuildingAddressDBServiceImpl implements BuildingAddressDBService{

	@Autowired
	private BuildingAddressDBRepository buildingAddressDBRepository ;

	@Override
	public List<BuildingAddressDB> getAllBuildingAddress() {
		return (List<BuildingAddressDB>) buildingAddressDBRepository.findAll();
	}

	@Override
	public List<String> getAllMainGovernorate() {
		return buildingAddressDBRepository.findAllMainGovernorate();
	}

	@Override
	public List<String> getAllSubGovernorate() {
		return buildingAddressDBRepository.findAllSubGovernorate();
	}

	@Override
	public List<String> getAllNeighborhood() {
		return buildingAddressDBRepository.findAllNeighborhood();
	}

	@Override
	public List<BuildingAddressDB> findAllByMainGovernorate(String mainGovernorate) {
		return buildingAddressDBRepository.findAllByMainGovernorate(mainGovernorate);
	}

	@Override
	public List<BuildingAddressDB> findAllBySubGovernorate(String neighborhood) {
		return buildingAddressDBRepository.findAllByNeighborhood(neighborhood);
	}

	@Override
	public BuildingAddressDB save(BuildingAddressDB buildingAddressDB) {
		buildingAddressDB.setCreatedDate(new Date());
		return buildingAddressDBRepository.save(buildingAddressDB);
	}

	@Override
	public BuildingAddressDB update(BuildingAddressDB buildingAddressDB) {
		buildingAddressDB.setUpdatedDate(new Date());
		return buildingAddressDBRepository.save(buildingAddressDB);
	}

	@Override
	public void delete(Long id) {
		buildingAddressDBRepository.deleteById(id);
	}

	@Override
	public BuildingAddressDB getCategoryById(Long id) {
		return buildingAddressDBRepository.findById(id).get() ;
	}

	@Override
	public List<BuildingAddressDB> findAllBySubGovernorateAndMainGovernorate(String subGovernorate,
			String mainGovernorate) {
		return buildingAddressDBRepository.findAllBySubGovernorateAndMainGovernorate(subGovernorate, mainGovernorate);
	}
}
