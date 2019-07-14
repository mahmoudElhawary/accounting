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
public class BuildingTransportationNearby {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long buildingTransportationNearbyId;
	
	private String busStop;
	private String taxiStand;
	private String minibus;
	private String subway;
	private String tram;
	private String trainStation;
	private String airport;
	
	@OneToMany(mappedBy = "buildingsId")
    @JsonIgnore
    private List<Buildings> buildings;
	
	public List<Buildings> getBuildings() {
		return buildings;
	}
	public void setBuildings(List<Buildings> buildings) {
		this.buildings = buildings;
	}
	public Long getBuildingTransportationNearbyId() {
		return buildingTransportationNearbyId;
	}
	public void setBuildingTransportationNearbyId(Long buildingTransportationNearbyId) {
		this.buildingTransportationNearbyId = buildingTransportationNearbyId;
	}
	public String getBusStop() {
		return busStop;
	}
	public void setBusStop(String busStop) {
		this.busStop = busStop;
	}
	public String getTaxiStand() {
		return taxiStand;
	}
	public void setTaxiStand(String taxiStand) {
		this.taxiStand = taxiStand;
	}
	public String getMinibus() {
		return minibus;
	}
	public void setMinibus(String minibus) {
		this.minibus = minibus;
	}
	public String getSubway() {
		return subway;
	}
	public void setSubway(String subway) {
		this.subway = subway;
	}
	public String getTram() {
		return tram;
	}
	public void setTram(String tram) {
		this.tram = tram;
	}
	public String getTrainStation() {
		return trainStation;
	}
	public void setTrainStation(String trainStation) {
		this.trainStation = trainStation;
	}
	public String getAirport() {
		return airport;
	}
	public void setAirport(String airport) {
		this.airport = airport;
	}
	
}
