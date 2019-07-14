package com.elhawary.semsar.service;

import java.util.List;

import com.elhawary.semsar.model.Buildings;

public interface BuildingsService {

	List<Buildings> findAll();

	Buildings findById(Long id);

	Buildings saveBuildings(Buildings buildings);

	Buildings updateBuildings(Buildings buildings);

	void deleteById(Long id);

	List<Buildings> findAllByUserRole(String role);

	List<Buildings> findAllByUserId(Long id);

	List<Buildings> findAllByBuildingDepartmentBuildingDepartment(String department);

	List<Buildings> findTop18ByOrderByCreatedDateDesc();

	List<Buildings> findTop18ByOrderByBuildingContractCountDesc();

	List<Buildings> findTop18ByOrderByBuildingSearchCountDesc();

	List<Buildings> findTop18ByOrderByBuildingCommentsCommentCountDesc();

	List<Buildings> findTop18ByOrderByBuildingRateDesc();

	List<Buildings> findTop18ByOrderByBuildingViewDesc();
}
