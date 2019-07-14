package com.elhawary.semsar.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elhawary.semsar.model.BuildingPhoto;

@Repository
public interface BuildingPhotoRepository extends CrudRepository<BuildingPhoto, Long> {

	List<BuildingPhoto> findAllByBuildingsBuildingsId(Long id) ;
	List<BuildingPhoto> findAllByBuildingsUserId(Long id) ;
}
