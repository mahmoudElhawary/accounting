package com.elhawary.semsar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elhawary.semsar.model.BuildingAddressDB;

@Repository
public interface BuildingAddressDBRepository extends CrudRepository<BuildingAddressDB, Long> {

	List<BuildingAddressDB> findAllByMainGovernorate(String mainGovernorate);
	
	List<BuildingAddressDB> findAllBySubGovernorate(String subGovernorate);
	
	List<BuildingAddressDB> findAllBySubGovernorateAndMainGovernorate(String subGovernorate , String mainGovernorate);
	
	List<BuildingAddressDB> findAllByNeighborhood(String neighborhood);
	
	@Query(value = "SELECT DISTINCT main_governorate from building_addressdb" , nativeQuery = true)
	List<String> findAllMainGovernorate();
	
	@Query(value = "SELECT DISTINCT sub_governorate from building_addressdb" , nativeQuery = true)
	List<String> findAllSubGovernorate();
	
	@Query(value = "SELECT DISTINCT neighborhood from building_addressdb" , nativeQuery = true)
	List<String> findAllNeighborhood();
}
