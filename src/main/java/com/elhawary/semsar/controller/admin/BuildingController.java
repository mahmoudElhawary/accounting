package com.elhawary.semsar.controller.admin;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.elhawary.semsar.domain.Response;
import com.elhawary.semsar.model.BuildingPhoto;
import com.elhawary.semsar.model.Buildings;
import com.elhawary.semsar.model.User;
import com.elhawary.semsar.service.BuildingsService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class BuildingController {

	@Autowired
	private BuildingsService buildingsService;

	@PostMapping("/createBuilding")
	public ResponseEntity<List<Buildings>> createBuilding(
			@RequestParam("buildingFiles") List<MultipartFile> buildingFiles, @RequestParam("building") String building,
			@RequestParam("user") String user) throws JsonParseException, JsonMappingException, IOException {
		if (building == null) {
			throw new NullPointerException();
		}
		User userData = new ObjectMapper().readValue(user, User.class);
		Buildings buildingData = new ObjectMapper().readValue(user, Buildings.class);
		
		for (BuildingPhoto buildingPhoto : buildingData.getBuildingPhotos()) {
			for (MultipartFile multipartFile : buildingFiles) {
				buildingPhoto.setBuildingPhoto(multipartFile.getBytes());
			}
		}
		buildingsService.saveBuildings(buildingData) ;
		List<Buildings> buildings = buildingsService.findAllByUserId(userData.getId());
		return new ResponseEntity<List<Buildings>>(buildings, HttpStatus.OK);
	}

	@PostMapping("/findAllByBuildingDepartment")
	public ResponseEntity<List<Buildings>> findAllByBuildingDepartment(@RequestBody String department) {
		if (department == null) {
			throw new NullPointerException();
		}
		List<Buildings> buildings = buildingsService.findAllByBuildingDepartmentBuildingDepartment(department);
		return new ResponseEntity<List<Buildings>>(buildings, HttpStatus.OK);
	}

	@GetMapping("/getBuildingById/{id}")
	public ResponseEntity<Buildings> getBuildingById(@PathVariable("id") Long id) {
		if (id != null) {
			Buildings buildings = buildingsService.findById(id);
			return new ResponseEntity<Buildings>(buildings, HttpStatus.OK);
		} else {
			return null;
		}
	}

	@GetMapping("/deleteBuildingById/{id}")
	public ResponseEntity<Response> deleteBuildingById(@PathVariable("id") Long id) {
		if (id != null) {
			buildingsService.deleteById(id);
			return new ResponseEntity<Response>(new Response("deleted successfully"), HttpStatus.OK);
		} else {
			return null;
		}
	}

	@GetMapping("/getAllBuildings")
	public ResponseEntity<List<Buildings>> getAllBuildings() {
		List<Buildings> buildings = buildingsService.findAll();
		return new ResponseEntity<List<Buildings>>(buildings, HttpStatus.OK);
	}

	@GetMapping("/getAllAdminBuildings")
	public ResponseEntity<List<Buildings>> getAllAdminBuildings() {
		List<Buildings> buildings = buildingsService.findAllByUserRole("ADMIN");
		return new ResponseEntity<List<Buildings>>(buildings, HttpStatus.OK);
	}

	@GetMapping("/getAllUserBuildings")
	public ResponseEntity<List<Buildings>> getAllUserBuildings() {
		List<Buildings> buildings = buildingsService.findAllByUserRole("USER");
		return new ResponseEntity<List<Buildings>>(buildings, HttpStatus.OK);
	}

	@GetMapping("/getAllBuildingsByMaxCommentCount")
	public ResponseEntity<List<Buildings>> getAllBuildingsByMaxCommentCount() {
		List<Buildings> buildings = buildingsService.findTop18ByOrderByBuildingCommentsCommentCountDesc();
		return new ResponseEntity<List<Buildings>>(buildings, HttpStatus.OK);
	}

	@GetMapping("/getAllBuildingsByMaxContractCount")
	public ResponseEntity<List<Buildings>> getAllBuildingsByMaxContractCount() {
		List<Buildings> buildings = buildingsService.findTop18ByOrderByBuildingContractCountDesc();
		return new ResponseEntity<List<Buildings>>(buildings, HttpStatus.OK);
	}

	@GetMapping("/getAllBuildingsByMaxRateNumber")
	public ResponseEntity<List<Buildings>> getAllBuildingsByMaxRateNumber() {
		List<Buildings> buildings = buildingsService.findTop18ByOrderByBuildingRateDesc();
		return new ResponseEntity<List<Buildings>>(buildings, HttpStatus.OK);
	}

	@GetMapping("/getAllBuildingsByMaxSearchCount")
	public ResponseEntity<List<Buildings>> getAllBuildingsByMaxSearchCount() {
		List<Buildings> buildings = buildingsService.findTop18ByOrderByBuildingSearchCountDesc();
		return new ResponseEntity<List<Buildings>>(buildings, HttpStatus.OK);
	}

	@GetMapping("/getAllBuildingsByMaxViewNumber")
	public ResponseEntity<List<Buildings>> getAllBuildingsByMaxViewNumber() {
		List<Buildings> buildings = buildingsService.findTop18ByOrderByBuildingViewDesc();
		return new ResponseEntity<List<Buildings>>(buildings, HttpStatus.OK);
	}

	@GetMapping("/getAllBuildingsByCreatedDate")
	public ResponseEntity<List<Buildings>> getAllBuildingsByCreatedDate() {
		List<Buildings> buildings = buildingsService.findTop18ByOrderByCreatedDateDesc();
		return new ResponseEntity<List<Buildings>>(buildings, HttpStatus.OK);
	}
}
