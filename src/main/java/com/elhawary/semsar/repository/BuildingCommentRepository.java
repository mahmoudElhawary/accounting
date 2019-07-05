package com.elhawary.semsar.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elhawary.semsar.model.BuildingComment;

@Repository
public interface BuildingCommentRepository extends CrudRepository<BuildingComment, Long> {

	List<BuildingComment> findAllByBuildingsBuildingsId(Long id);
}
