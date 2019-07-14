package com.elhawary.semsar.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.elhawary.semsar.domain.Response;
import com.elhawary.semsar.model.Buildings;
import com.elhawary.semsar.service.BuildingSerachService;
import com.elhawary.semsar.service.BuildingsService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class SearchController {

	@Autowired
	private BuildingSerachService buildingsService;

	List<Buildings> buildings = new ArrayList<Buildings>();

	@PostMapping("/searchBuildingByPrice")
	public ResponseEntity<List<Buildings>> searchBuildingByPrice(
			@RequestParam("buildingMaxPrice") String buildingMaxPrice,
			@RequestParam("buildingMinPrice") String buildingMinPrice)
			throws JsonParseException, JsonMappingException, IOException {
		
		double maxPrice = new ObjectMapper().readValue(buildingMaxPrice, Double.class);
		double minPrice = new ObjectMapper().readValue(buildingMinPrice, Double.class);
		buildings = buildingsService.searchByPrice(minPrice, maxPrice) ;
		return new ResponseEntity<List<Buildings>>(buildings, HttpStatus.OK);
	}
	@PostMapping("/searchBuilding")
	public ResponseEntity<List<Buildings>> createBuilding(@RequestParam("building") String building,
			@RequestParam("minArea") String minArea, @RequestParam("maxArea") String maxArea,
			@RequestParam("buildingMaxPrice") String buildingMaxPrice,
			@RequestParam("buildingMinPrice") String buildingMinPrice)
			throws JsonParseException, JsonMappingException, IOException {
		if (building == null) {
			throw new NullPointerException();
		}
		Buildings buildingData = new ObjectMapper().readValue(building, Buildings.class);
		double areaMin = new ObjectMapper().readValue(minArea, Double.class);
		double areaMax = new ObjectMapper().readValue(maxArea, Double.class);
		double maxPrice = new ObjectMapper().readValue(buildingMaxPrice, Double.class);
		double minPrice = new ObjectMapper().readValue(buildingMinPrice, Double.class);

		if (buildingData.getRoomsNumber() != 0) {
			buildings = buildingsService.searchByAllAttributes(
					buildingData.getBuildingDepartment().getBuildingDepartment(),
					buildingData.getBuildingAddress().getMainGovernorate(),
					buildingData.getBuildingAddress().getSubGovernorate(),
					buildingData.getBuildingAddress().getNeighborhood(), buildingData.getRoomsNumber(),
					buildingData.getBathroomNumber(), buildingData.getFloorNumber(), buildingData.getFurniture(),
					buildingData.getFinishingType(), buildingData.getPaymentMethod(), buildingData.getPurpose(),
					areaMin, areaMax, maxPrice, minPrice);
		}

		else if (buildingData.getRoomsNumber() == 0) {
			buildings = buildingsService.searchByAllAttributesWithoutRoomsNumber(
					buildingData.getBuildingDepartment().getBuildingDepartment(),
					buildingData.getBuildingAddress().getMainGovernorate(),
					buildingData.getBuildingAddress().getSubGovernorate(),
					buildingData.getBuildingAddress().getNeighborhood(), buildingData.getFurniture(),
					buildingData.getFinishingType(), buildingData.getPaymentMethod(), buildingData.getPurpose(),
					areaMin, areaMax, maxPrice, minPrice);
		} else if (buildingData.getRoomsNumber() == 0 && buildingData.getFurniture() == null) {
			buildings = buildingsService.searchByDepartmentAddressPymentPurposeAreaPrice(
					buildingData.getBuildingDepartment().getBuildingDepartment(),
					buildingData.getBuildingAddress().getMainGovernorate(),
					buildingData.getBuildingAddress().getSubGovernorate(),
					buildingData.getBuildingAddress().getNeighborhood(), buildingData.getPaymentMethod(),
					buildingData.getPurpose(), areaMin, areaMax, maxPrice, minPrice);
		} else if (buildingData.getRoomsNumber() == 0 && buildingData.getFurniture() == null
				&& buildingData.getPaymentMethod() == null) {
			buildings = buildingsService.searchByRequeredAttributes(
					buildingData.getBuildingDepartment().getBuildingDepartment(),
					buildingData.getBuildingAddress().getMainGovernorate(),
					buildingData.getBuildingAddress().getSubGovernorate(),
					buildingData.getBuildingAddress().getNeighborhood(), areaMin, areaMax, maxPrice, minPrice);
		}
		return new ResponseEntity<List<Buildings>>(buildings, HttpStatus.OK);
	}
}
