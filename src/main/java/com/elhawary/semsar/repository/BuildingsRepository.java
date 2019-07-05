package com.elhawary.semsar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elhawary.semsar.model.Buildings;

@Repository
public interface BuildingsRepository extends CrudRepository<Buildings, Long> {

}
