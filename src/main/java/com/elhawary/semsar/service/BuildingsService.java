package com.elhawary.semsar.service;

import java.util.List;

import com.elhawary.semsar.model.Buildings;

public interface BuildingsService {

	List<Buildings> findAll() ;
	Buildings findById(Long id) ;
	Buildings saveBuildings(Buildings buildings) ;
	Buildings updateBuildings(Buildings buildings) ;
	void deleteById(Long id) ;
}
