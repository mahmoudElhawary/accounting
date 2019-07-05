package com.elhawary.semsar.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elhawary.semsar.model.Buildings;

@Repository
public interface BuildingsRepository extends CrudRepository<Buildings, Long> {
	
	List<Buildings> findAllByUserRole(String role) ;
	
	List<Buildings> findAllByUserId(Long id) ;
	
	List<Buildings> findAllByBuildingDepartmentBuildingDepartment(String department) ;
	
	List<Buildings> findTop18ByOrderByCreatedDateDesc();

    List<Buildings> findTop18ByOrderByBuildingContractCountDesc();
    
    List<Buildings> findTop18ByOrderByBuildingSearchCountDesc();

    List<Buildings> findTop18ByOrderByBuildingCommentsCommentCountDesc();
    
    List<Buildings> findTop18ByOrderByBuildingRateDesc();
    
    List<Buildings> findTop18ByOrderByBuildingViewDesc();
}
