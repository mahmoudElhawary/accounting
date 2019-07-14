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
public class BuildingCloseTo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long buildingCloseToId;
	
	private String mosque;
	private String church;
	private String school;
	private String university;
	private String hospital;
	private String babyDaycare;
	private String medicalCenter;
	private String pharmacy;
	private String shoppingMall;
	private String grocers;
	private String policeStation;
	private String sportsClup;
	private String fitnessGym;
	private String postOffice;
	private String bank;
	private String highway;
	private String gasStation;
	private String cityCenter;
	
	@OneToMany(mappedBy = "buildingsId")
    @JsonIgnore
    private List<Buildings> buildings;
	
	public List<Buildings> getBuildings() {
		return buildings;
	}
	public void setBuildings(List<Buildings> buildings) {
		this.buildings = buildings;
	}
	public Long getBuildingCloseToId() {
		return buildingCloseToId;
	}
	public void setBuildingCloseToId(Long buildingCloseToId) {
		this.buildingCloseToId = buildingCloseToId;
	}
	public String getMosque() {
		return mosque;
	}
	public void setMosque(String mosque) {
		this.mosque = mosque;
	}
	public String getChurch() {
		return church;
	}
	public void setChurch(String church) {
		this.church = church;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getBabyDaycare() {
		return babyDaycare;
	}
	public void setBabyDaycare(String babyDaycare) {
		this.babyDaycare = babyDaycare;
	}
	public String getMedicalCenter() {
		return medicalCenter;
	}
	public void setMedicalCenter(String medicalCenter) {
		this.medicalCenter = medicalCenter;
	}
	public String getPharmacy() {
		return pharmacy;
	}
	public void setPharmacy(String pharmacy) {
		this.pharmacy = pharmacy;
	}
	public String getShoppingMall() {
		return shoppingMall;
	}
	public void setShoppingMall(String shoppingMall) {
		this.shoppingMall = shoppingMall;
	}
	public String getGrocers() {
		return grocers;
	}
	public void setGrocers(String grocers) {
		this.grocers = grocers;
	}
	public String getPoliceStation() {
		return policeStation;
	}
	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}
	public String getSportsClup() {
		return sportsClup;
	}
	public void setSportsClup(String sportsClup) {
		this.sportsClup = sportsClup;
	}
	public String getFitnessGym() {
		return fitnessGym;
	}
	public void setFitnessGym(String fitnessGym) {
		this.fitnessGym = fitnessGym;
	}
	public String getPostOffice() {
		return postOffice;
	}
	public void setPostOffice(String postOffice) {
		this.postOffice = postOffice;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getHighway() {
		return highway;
	}
	public void setHighway(String highway) {
		this.highway = highway;
	}
	public String getGasStation() {
		return gasStation;
	}
	public void setGasStation(String gasStation) {
		this.gasStation = gasStation;
	}
	public String getCityCenter() {
		return cityCenter;
	}
	public void setCityCenter(String cityCenter) {
		this.cityCenter = cityCenter;
	}
}
