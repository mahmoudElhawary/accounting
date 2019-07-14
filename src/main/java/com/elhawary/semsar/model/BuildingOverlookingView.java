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
public class BuildingOverlookingView {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long buildingOverlookingViewId;
	
	private String mainStreet;
	private String sideStreet;
	private String naturalView;
	private String garden;
	private String river;
	private String sea;
	private String lake;
	private String pool;
	
	@OneToMany(mappedBy = "buildingsId")
    @JsonIgnore
    private List<Buildings> buildings;
	
	public List<Buildings> getBuildings() {
		return buildings;
	}
	public void setBuildings(List<Buildings> buildings) {
		this.buildings = buildings;
	}
	public Long getBuildingOverlookingViewId() {
		return buildingOverlookingViewId;
	}
	public void setBuildingOverlookingViewId(Long buildingOverlookingViewId) {
		this.buildingOverlookingViewId = buildingOverlookingViewId;
	}
	public String getMainStreet() {
		return mainStreet;
	}
	public void setMainStreet(String mainStreet) {
		this.mainStreet = mainStreet;
	}
	public String getSideStreet() {
		return sideStreet;
	}
	public void setSideStreet(String sideStreet) {
		this.sideStreet = sideStreet;
	}
	public String getNaturalView() {
		return naturalView;
	}
	public void setNaturalView(String naturalView) {
		this.naturalView = naturalView;
	}
	public String getGarden() {
		return garden;
	}
	public void setGarden(String garden) {
		this.garden = garden;
	}
	public String getRiver() {
		return river;
	}
	public void setRiver(String river) {
		this.river = river;
	}
	public String getSea() {
		return sea;
	}
	public void setSea(String sea) {
		this.sea = sea;
	}
	public String getLake() {
		return lake;
	}
	public void setLake(String lake) {
		this.lake = lake;
	}
	public String getPool() {
		return pool;
	}
	public void setPool(String pool) {
		this.pool = pool;
	}
}
