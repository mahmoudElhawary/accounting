package com.elhawary.semsar.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class BuildingDepartment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long buildingDepartmentId;
	
	private String buildingDepartment ;
	
	@OneToMany(mappedBy = "buildingsId")
    @JsonIgnore
    private List<Buildings> buildings;

	public Long getBuildingDepartmentId() {
		return buildingDepartmentId;
	}

	public void setBuildingDepartmentId(Long buildingDepartmentId) {
		this.buildingDepartmentId = buildingDepartmentId;
	}

	public String getBuildingDepartment() {
		return buildingDepartment;
	}

	public void setBuildingDepartment(String buildingDepartment) {
		this.buildingDepartment = buildingDepartment;
	}

	public List<Buildings> getBuildings() {
		return buildings;
	}

	public void setBuildings(List<Buildings> buildings) {
		this.buildings = buildings;
	}

}
