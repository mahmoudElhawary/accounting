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

import com.elhawary.semsar.domain.Response;
import com.elhawary.semsar.model.BuildingAddressDB;
import com.elhawary.semsar.service.BuildingAddressDBService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class BuildingAddressDBController {

	@Autowired
	private BuildingAddressDBService buildingAddressDBService;

	@GetMapping("/getAllBuildingAddress")
	public ResponseEntity<List<BuildingAddressDB>> getAllBuildingAddress() {
		List<BuildingAddressDB> buildingAddressDBs = buildingAddressDBService.getAllBuildingAddress();
		return new ResponseEntity<List<BuildingAddressDB>>(buildingAddressDBs, HttpStatus.OK);
	}

	@GetMapping("/getAllMainGovernorate")
	public ResponseEntity<List<String>> getAllMainGovernorate() {
		List<String> buildingAddressDBs = buildingAddressDBService.getAllMainGovernorate();
		return new ResponseEntity<List<String>>(buildingAddressDBs, HttpStatus.OK);
	}

	@GetMapping("/getAllSubGovernorate")
	public ResponseEntity<List<String>> getAllSubGovernorate() {
		List<String> buildingAddressDBs = buildingAddressDBService.getAllSubGovernorate();
		return new ResponseEntity<List<String>>(buildingAddressDBs, HttpStatus.OK);
	}

	@GetMapping("/getAllNeighborhood")
	public ResponseEntity<List<String>> getAllNeighborhood() {
		List<String> buildingAddressDBs = buildingAddressDBService.getAllNeighborhood();
		return new ResponseEntity<List<String>>(buildingAddressDBs, HttpStatus.OK);
	}

	@PostMapping("/findAllByMainGovernorate")
	public ResponseEntity<List<BuildingAddressDB>> findAllByMainGovernorate(@RequestBody String mainGovernorate) {
		List<BuildingAddressDB> buildingAddressDBs = buildingAddressDBService.findAllByMainGovernorate(mainGovernorate);
		return new ResponseEntity<List<BuildingAddressDB>>(buildingAddressDBs, HttpStatus.OK);
	}

	@PostMapping("/findAllBySubGovernorate")
	public ResponseEntity<List<BuildingAddressDB>> findAllBySubGovernorate(@RequestBody String subGovernorate) {
		List<BuildingAddressDB> buildingAddressDBs = buildingAddressDBService.findAllBySubGovernorate(subGovernorate);
		return new ResponseEntity<List<BuildingAddressDB>>(buildingAddressDBs, HttpStatus.OK);
	}

	@PostMapping("/findAllBySubGovernorateAndMainGovernorate")
	public ResponseEntity<List<BuildingAddressDB>> findAllBySubGovernorateAndMainGovernorate(
			@RequestParam("subGovernorate") String subGovernorate,
			@RequestParam("mainGovernorate") String mainGovernorate)
			throws JsonParseException, JsonMappingException, IOException {
		String sub = new ObjectMapper().readValue(subGovernorate, String.class);
		String main = new ObjectMapper().readValue(mainGovernorate, String.class);
		List<BuildingAddressDB> buildingAddressDBs = buildingAddressDBService
				.findAllBySubGovernorateAndMainGovernorate(sub, main);
		return new ResponseEntity<List<BuildingAddressDB>>(buildingAddressDBs, HttpStatus.OK);
	}

	@PostMapping("/createBuildingAddressDB")
	public ResponseEntity<List<BuildingAddressDB>> createBuildingAddressDB(
			@RequestBody BuildingAddressDB buildingAddressDB) {
		if (buildingAddressDB != null) {
			buildingAddressDBService.save(buildingAddressDB);
			List<BuildingAddressDB> buildingAddressDBs = buildingAddressDBService.getAllBuildingAddress();
			return new ResponseEntity<List<BuildingAddressDB>>(buildingAddressDBs, HttpStatus.OK);
		} else {
			return null;
		}
	}

	@PostMapping("/updateBuildingAddressDB")
	public ResponseEntity<List<BuildingAddressDB>> updateBuildingAddressDB(
			@RequestParam("buildingAddress") String buildingAddress, @RequestParam("id") String id)
			throws JsonParseException, JsonMappingException, IOException {
		if (buildingAddress == null) {
			throw new NullPointerException();
		}
		BuildingAddressDB buildingAddressDB = new ObjectMapper().readValue(buildingAddress, BuildingAddressDB.class);
		buildingAddressDBService.save(buildingAddressDB);
		List<BuildingAddressDB> buildingAddressDBs = buildingAddressDBService.getAllBuildingAddress();
		return new ResponseEntity<List<BuildingAddressDB>>(buildingAddressDBs, HttpStatus.OK);
	}

	@GetMapping("/deleteBuildingAddressDB/{id}")
	public ResponseEntity<Response> deleteBuildingAddressDB(@PathVariable("id") Long id) {
		if (id != null) {
			BuildingAddressDB addressDB = buildingAddressDBService.getCategoryById(id);
			buildingAddressDBService.delete(addressDB.getBuildingAddressDBId());
			return new ResponseEntity<Response>(new Response("this Category deleted successfully"), HttpStatus.OK);
		} else {
			return null;
		}
	}

	@GetMapping("/getBuildingAddressDB/{id}")
	public ResponseEntity<BuildingAddressDB> getBuildingAddressDB(@PathVariable("id") Long id) {
		if (id != null) {
			BuildingAddressDB addressDB = buildingAddressDBService.getCategoryById(id);
			return new ResponseEntity<BuildingAddressDB>(addressDB, HttpStatus.OK);
		} else {
			return null;
		}
	}
}
