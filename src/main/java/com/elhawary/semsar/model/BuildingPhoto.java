package com.elhawary.semsar.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class BuildingPhoto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long buildingPhotoId;
	
	@Lob
	@Basic(fetch = FetchType.EAGER)
	private byte[] buildingPhoto;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "buildingsId")
	private Buildings buildings;

	public Buildings getBuildings() {
		return buildings;
	}

	public void setBuildings(Buildings buildings) {
		this.buildings = buildings;
	}

	public Long getBuildingPhotoId() {
		return buildingPhotoId;
	}

	public void setBuildingPhotoId(Long buildingPhotoId) {
		this.buildingPhotoId = buildingPhotoId;
	}

	public byte[] getBuildingPhoto() {
		return buildingPhoto;
	}

	public void setBuildingPhoto(byte[] buildingPhoto) {
		this.buildingPhoto = buildingPhoto;
	}
}
