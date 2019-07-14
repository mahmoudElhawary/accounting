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
public class BuildingInternalFeatures {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long buildingInternalFeaturesId;
	
	private String conditioning;
	private String heating;
	private String naturalGas;
	private String balcony;
	private String privateGarden;
	private String roomService;
	private String storageRoom;
	private String deskRoom;
	private String closet;
	private String internet;
	private String teleghone;
	private String oven;
	private String washingMachine;
	private String dishWasher;
	private String microwave;
	private String refrigerator;
	private String waterHeater;
	private String doubleWindowGlass;
	private String privateJacuzzi;
	private String privateGym;
	private String privatePool;
	private String sauna;
	
	@OneToMany(mappedBy = "buildingsId")
    @JsonIgnore
    private List<Buildings> buildings;
	
	public List<Buildings> getBuildings() {
		return buildings;
	}
	public void setBuildings(List<Buildings> buildings) {
		this.buildings = buildings;
	}
	public Long getBuildingInternalFeaturesId() {
		return buildingInternalFeaturesId;
	}
	public void setBuildingInternalFeaturesId(Long buildingInternalFeaturesId) {
		this.buildingInternalFeaturesId = buildingInternalFeaturesId;
	}
	public String getConditioning() {
		return conditioning;
	}
	public void setConditioning(String conditioning) {
		this.conditioning = conditioning;
	}
	public String getHeating() {
		return heating;
	}
	public void setHeating(String heating) {
		this.heating = heating;
	}
	public String getNaturalGas() {
		return naturalGas;
	}
	public void setNaturalGas(String naturalGas) {
		this.naturalGas = naturalGas;
	}
	public String getBalcony() {
		return balcony;
	}
	public void setBalcony(String balcony) {
		this.balcony = balcony;
	}
	public String getPrivateGarden() {
		return privateGarden;
	}
	public void setPrivateGarden(String privateGarden) {
		this.privateGarden = privateGarden;
	}
	public String getRoomService() {
		return roomService;
	}
	public void setRoomService(String roomService) {
		this.roomService = roomService;
	}
	public String getStorageRoom() {
		return storageRoom;
	}
	public void setStorageRoom(String storageRoom) {
		this.storageRoom = storageRoom;
	}
	public String getDeskRoom() {
		return deskRoom;
	}
	public void setDeskRoom(String deskRoom) {
		this.deskRoom = deskRoom;
	}
	public String getCloset() {
		return closet;
	}
	public void setCloset(String closet) {
		this.closet = closet;
	}
	public String getInternet() {
		return internet;
	}
	public void setInternet(String internet) {
		this.internet = internet;
	}
	public String getTeleghone() {
		return teleghone;
	}
	public void setTeleghone(String teleghone) {
		this.teleghone = teleghone;
	}
	public String getOven() {
		return oven;
	}
	public void setOven(String oven) {
		this.oven = oven;
	}
	public String getWashingMachine() {
		return washingMachine;
	}
	public void setWashingMachine(String washingMachine) {
		this.washingMachine = washingMachine;
	}
	public String getDishWasher() {
		return dishWasher;
	}
	public void setDishWasher(String dishWasher) {
		this.dishWasher = dishWasher;
	}
	public String getMicrowave() {
		return microwave;
	}
	public void setMicrowave(String microwave) {
		this.microwave = microwave;
	}
	public String getRefrigerator() {
		return refrigerator;
	}
	public void setRefrigerator(String refrigerator) {
		this.refrigerator = refrigerator;
	}
	public String getWaterHeater() {
		return waterHeater;
	}
	public void setWaterHeater(String waterHeater) {
		this.waterHeater = waterHeater;
	}
	public String getDoubleWindowGlass() {
		return doubleWindowGlass;
	}
	public void setDoubleWindowGlass(String doubleWindowGlass) {
		this.doubleWindowGlass = doubleWindowGlass;
	}
	public String getPrivateJacuzzi() {
		return privateJacuzzi;
	}
	public void setPrivateJacuzzi(String privateJacuzzi) {
		this.privateJacuzzi = privateJacuzzi;
	}
	public String getPrivateGym() {
		return privateGym;
	}
	public void setPrivateGym(String privateGym) {
		this.privateGym = privateGym;
	}
	public String getPrivatePool() {
		return privatePool;
	}
	public void setPrivatePool(String privatePool) {
		this.privatePool = privatePool;
	}
	public String getSauna() {
		return sauna;
	}
	public void setSauna(String sauna) {
		this.sauna = sauna;
	}
	
}
