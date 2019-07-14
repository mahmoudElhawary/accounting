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
public class BuildingFeatures {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long buildingFeaturesId;
	
	private String elevator;
	private String carPark;
	private String security ;
	private String conciergeService;
	private String securityCameras;
	private String centralTV;
	private String fireAlarm;
	private String theftalarm;
	private String generators;
	private String closedSwimmingPool;
	private String opendSwimmingPool;
	private String gardens;
	private String playground;
	private String gangway;
	private String industrialLakes;
	private String sportClub;
	private String shoppingCenter;
	private String babyDaycare;
	private String cafesRestaurants;
	private String healthTreatmentCenter;
	private String outWall;
	private String gate;
	
	@OneToMany(mappedBy = "buildingsId")
    @JsonIgnore
    private List<Buildings> buildings;
	
	public List<Buildings> getBuildings() {
		return buildings;
	}
	public void setBuildings(List<Buildings> buildings) {
		this.buildings = buildings;
	}
	public Long getBuildingFeaturesId() {
		return buildingFeaturesId;
	}
	public void setBuildingFeaturesId(Long buildingFeaturesId) {
		this.buildingFeaturesId = buildingFeaturesId;
	}
	public String getElevator() {
		return elevator;
	}
	public void setElevator(String elevator) {
		this.elevator = elevator;
	}
	public String getCarPark() {
		return carPark;
	}
	public void setCarPark(String carPark) {
		this.carPark = carPark;
	}
	public String getSecurity() {
		return security;
	}
	public void setSecurity(String security) {
		this.security = security;
	}
	public String getConciergeService() {
		return conciergeService;
	}
	public void setConciergeService(String conciergeService) {
		this.conciergeService = conciergeService;
	}
	public String getSecurityCameras() {
		return securityCameras;
	}
	public void setSecurityCameras(String securityCameras) {
		this.securityCameras = securityCameras;
	}
	public String getCentralTV() {
		return centralTV;
	}
	public void setCentralTV(String centralTV) {
		this.centralTV = centralTV;
	}
	public String getFireAlarm() {
		return fireAlarm;
	}
	public void setFireAlarm(String fireAlarm) {
		this.fireAlarm = fireAlarm;
	}
	public String getTheftalarm() {
		return theftalarm;
	}
	public void setTheftalarm(String theftalarm) {
		this.theftalarm = theftalarm;
	}
	public String getGenerators() {
		return generators;
	}
	public void setGenerators(String generators) {
		this.generators = generators;
	}
	public String getClosedSwimmingPool() {
		return closedSwimmingPool;
	}
	public void setClosedSwimmingPool(String closedSwimmingPool) {
		this.closedSwimmingPool = closedSwimmingPool;
	}
	public String getOpendSwimmingPool() {
		return opendSwimmingPool;
	}
	public void setOpendSwimmingPool(String opendSwimmingPool) {
		this.opendSwimmingPool = opendSwimmingPool;
	}
	public String getGardens() {
		return gardens;
	}
	public void setGardens(String gardens) {
		this.gardens = gardens;
	}
	public String getPlayground() {
		return playground;
	}
	public void setPlayground(String playground) {
		this.playground = playground;
	}
	public String getGangway() {
		return gangway;
	}
	public void setGangway(String gangway) {
		this.gangway = gangway;
	}
	public String getIndustrialLakes() {
		return industrialLakes;
	}
	public void setIndustrialLakes(String industrialLakes) {
		this.industrialLakes = industrialLakes;
	}
	public String getSportClub() {
		return sportClub;
	}
	public void setSportClub(String sportClub) {
		this.sportClub = sportClub;
	}
	public String getShoppingCenter() {
		return shoppingCenter;
	}
	public void setShoppingCenter(String shoppingCenter) {
		this.shoppingCenter = shoppingCenter;
	}
	public String getBabyDaycare() {
		return babyDaycare;
	}
	public void setBabyDaycare(String babyDaycare) {
		this.babyDaycare = babyDaycare;
	}
	public String getCafesRestaurants() {
		return cafesRestaurants;
	}
	public void setCafesRestaurants(String cafesRestaurants) {
		this.cafesRestaurants = cafesRestaurants;
	}
	public String getHealthTreatmentCenter() {
		return healthTreatmentCenter;
	}
	public void setHealthTreatmentCenter(String healthTreatmentCenter) {
		this.healthTreatmentCenter = healthTreatmentCenter;
	}
	public String getOutWall() {
		return outWall;
	}
	public void setOutWall(String outWall) {
		this.outWall = outWall;
	}
	public String getGate() {
		return gate;
	}
	public void setGate(String gate) {
		this.gate = gate;
	}
	
}
