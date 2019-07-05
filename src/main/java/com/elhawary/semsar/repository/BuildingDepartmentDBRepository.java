package com.elhawary.semsar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elhawary.semsar.model.BuildingDepartmentDB;

@Repository
public interface BuildingDepartmentDBRepository extends CrudRepository<BuildingDepartmentDB, Long>{

}
