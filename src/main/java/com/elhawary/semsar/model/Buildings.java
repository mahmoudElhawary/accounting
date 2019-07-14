package com.elhawary.semsar.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Buildings {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long buildingsId;
	
	@OrderBy("productName asc")
	private String buildingName;

	private Date createdDate ;
	
	private Date updatedDate ;
	
	private String adsTopic ;
	
	private String purpose ;
	
	@Min(value = 0, message = "Product price must no be less then zero.")
	private double area ;
	
	@Min(value = 0, message = "Product price must no be less then zero.")
	private int roomsNumber ;
	
	@Min(value = 0, message = "Product price must no be less then zero.")
	private int bathroomNumber ;
	@Min(value = 0, message = "Product price must no be less then zero.")
	private int floorNumber ;
	
	@Min(value = 0, message = "Product price must no be less then zero.")
	private int constructionYear ;
	
	private String finishingType ;
	
	private String publisherType ;
	
	private String buildingFullAddress ;
	
	private String paymentMethod;
	
	private String buildingFullDescription ;
	
	private String videoonYouTube ;
	
	private String furniture ;
	
	@Min(value = 0, message = "Product price must no be less then zero.")
	private int buildingRate;


	@Column(name = "buildingView", nullable = false, columnDefinition = "bigint(20) default 0")
	private long buildingView = 0;
	
	@Column(name = "buildingContractCount", nullable = false, columnDefinition = "bigint(20) default 0")
	private long buildingContractCount = 0;
	
	@Column(name = "buildingSearchCount", nullable = false, columnDefinition = "bigint(20) default 0")
	private long buildingSearchCount = 0;

	@Min(value = 0, message = "Product price must no be less then zero.")
	private double buildingPrice;
	
	@Lob
	@Basic(fetch = FetchType.EAGER)
	private byte[] buildingPhoto;

	@OneToMany(mappedBy = "buildings", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<BuildingComment> buildingComments;

//	@OneToMany(mappedBy = "buildings", fetch = FetchType.EAGER)
//	private List<BuildingPhoto> buildingPhotos;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "buildingFeaturesId")
	private BuildingFeatures buildingFeatures;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "buildingInternalFeaturesId")
	private BuildingInternalFeatures buildingInternalFeatures;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "buildingOverlookingViewId")
	private BuildingOverlookingView buildingOverlookingView;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "buildingCloseToId")
	private BuildingCloseTo buildingCloseTo;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "buildingTransportationNearbyId")
	private BuildingTransportationNearby buildingTransportationNearby;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "buildingAddressId")
	private BuildingAddress buildingAddress;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "buildingDepartmentId")
	private BuildingDepartment buildingDepartment;
	
	@ManyToOne
	private User user;

	public Long getBuildingsId() {
		return buildingsId;
	}

	public void setBuildingsId(Long buildingsId) {
		this.buildingsId = buildingsId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getAdsTopic() {
		return adsTopic;
	}

	public void setAdsTopic(String adsTopic) {
		this.adsTopic = adsTopic;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public int getRoomsNumber() {
		return roomsNumber;
	}

	public void setRoomsNumber(int roomsNumber) {
		this.roomsNumber = roomsNumber;
	}

	public int getBathroomNumber() {
		return bathroomNumber;
	}

	public void setBathroomNumber(int bathroomNumber) {
		this.bathroomNumber = bathroomNumber;
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public int getConstructionYear() {
		return constructionYear;
	}

	public void setConstructionYear(int constructionYear) {
		this.constructionYear = constructionYear;
	}

	public String getFinishingType() {
		return finishingType;
	}

	public void setFinishingType(String finishingType) {
		this.finishingType = finishingType;
	}

	public String getPublisherType() {
		return publisherType;
	}

	public void setPublisherType(String publisherType) {
		this.publisherType = publisherType;
	}

	public String getBuildingFullAddress() {
		return buildingFullAddress;
	}

	public void setBuildingFullAddress(String buildingFullAddress) {
		this.buildingFullAddress = buildingFullAddress;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getBuildingFullDescription() {
		return buildingFullDescription;
	}

	public void setBuildingFullDescription(String buildingFullDescription) {
		this.buildingFullDescription = buildingFullDescription;
	}

	public String getVideoonYouTube() {
		return videoonYouTube;
	}

	public void setVideoonYouTube(String videoonYouTube) {
		this.videoonYouTube = videoonYouTube;
	}

	public String getFurniture() {
		return furniture;
	}

	public void setFurniture(String furniture) {
		this.furniture = furniture;
	}

//	public List<BuildingPhoto> getBuildingPhotos() {
//		return buildingPhotos;
//	}
//
//	public void setBuildingPhotos(List<BuildingPhoto> buildingPhotos) {
//		this.buildingPhotos = buildingPhotos;
//	}

	public int getBuildingRate() {
		return buildingRate;
	}

	public void setBuildingRate(int buildingRate) {
		this.buildingRate = buildingRate;
	}

	public long getBuildingView() {
		return buildingView;
	}

	public void setBuildingView(long buildingView) {
		this.buildingView = buildingView;
	}

	public double getBuildingPrice() {
		return buildingPrice;
	}

	public void setBuildingPrice(double buildingPrice) {
		this.buildingPrice = buildingPrice;
	}

	public List<BuildingComment> getBuildingComments() {
		return buildingComments;
	}

	public void setBuildingComments(List<BuildingComment> buildingComments) {
		this.buildingComments = buildingComments;
	}

	public BuildingAddress getBuildingAddress() {
		return buildingAddress;
	}

	public void setBuildingAddress(BuildingAddress buildingAddress) {
		this.buildingAddress = buildingAddress;
	}

	public BuildingFeatures getBuildingFeatures() {
		return buildingFeatures;
	}

	public void setBuildingFeatures(BuildingFeatures buildingFeatures) {
		this.buildingFeatures = buildingFeatures;
	}

	public BuildingInternalFeatures getBuildingInternalFeatures() {
		return buildingInternalFeatures;
	}

	public void setBuildingInternalFeatures(BuildingInternalFeatures buildingInternalFeatures) {
		this.buildingInternalFeatures = buildingInternalFeatures;
	}

	public BuildingOverlookingView getBuildingOverlookingView() {
		return buildingOverlookingView;
	}

	public void setBuildingOverlookingView(BuildingOverlookingView buildingOverlookingView) {
		this.buildingOverlookingView = buildingOverlookingView;
	}

	public BuildingCloseTo getBuildingCloseTo() {
		return buildingCloseTo;
	}

	public void setBuildingCloseTo(BuildingCloseTo buildingCloseTo) {
		this.buildingCloseTo = buildingCloseTo;
	}

	public BuildingTransportationNearby getBuildingTransportationNearby() {
		return buildingTransportationNearby;
	}

	public void setBuildingTransportationNearby(BuildingTransportationNearby buildingTransportationNearby) {
		this.buildingTransportationNearby = buildingTransportationNearby;
	}

	public BuildingDepartment getBuildingDepartment() {
		return buildingDepartment;
	}

	public void setBuildingDepartment(BuildingDepartment buildingDepartment) {
		this.buildingDepartment = buildingDepartment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public long getBuildingContractCount() {
		return buildingContractCount;
	}

	public void setBuildingContractCount(long buildingContractCount) {
		this.buildingContractCount = buildingContractCount;
	}

	public long getBuildingSearchCount() {
		return buildingSearchCount;
	}

	public void setBuildingSearchCount(long buildingSearchCount) {
		this.buildingSearchCount = buildingSearchCount;
	}

	public byte[] getBuildingPhoto() {
		return buildingPhoto;
	}

	public void setBuildingPhoto(byte[] buildingPhoto) {
		this.buildingPhoto = buildingPhoto;
	}
	
}
