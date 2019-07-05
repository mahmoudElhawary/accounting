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
import com.elhawary.semsar.model.BuildingDepartmentDB;
import com.elhawary.semsar.service.BuildingDepartmentDBService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class BuildingDepartmentDBController {

	@Autowired
	private BuildingDepartmentDBService departmentDBService;

	@GetMapping("/getAllBuildingDepartmentDB")
	public ResponseEntity<List<BuildingDepartmentDB>> getAllBuildingDepartmentDB() {
		List<BuildingDepartmentDB> buildingAddressDBs = departmentDBService.getAllBuildingDepartmentDB();
		return new ResponseEntity<List<BuildingDepartmentDB>>(buildingAddressDBs, HttpStatus.OK);
	}

	@PostMapping("/createBuildingDepartmentDB")
	public ResponseEntity<List<BuildingDepartmentDB>> createBuildingDepartmentDB(
			@RequestBody BuildingDepartmentDB buildingAddressDB) {
		if (buildingAddressDB != null) {
			departmentDBService.save(buildingAddressDB);
			List<BuildingDepartmentDB> buildingAddressDBs = departmentDBService.getAllBuildingDepartmentDB();
			return new ResponseEntity<List<BuildingDepartmentDB>>(buildingAddressDBs, HttpStatus.OK);
		} else {
			return null;
		}
	}

	@PostMapping("/updateBuildingDepartmentDB")
	public ResponseEntity<List<BuildingDepartmentDB>> updateBuildingDepartmentDB(
			@RequestParam("buildingAddress") String buildingAddress, @RequestParam("id") String id)
			throws JsonParseException, JsonMappingException, IOException {
		if (buildingAddress == null) {
			throw new NullPointerException();
		}
		BuildingDepartmentDB buildingAddressDB = new ObjectMapper().readValue(buildingAddress,
				BuildingDepartmentDB.class);
		departmentDBService.save(buildingAddressDB);
		List<BuildingDepartmentDB> buildingAddressDBs = departmentDBService.getAllBuildingDepartmentDB();
		return new ResponseEntity<List<BuildingDepartmentDB>>(buildingAddressDBs, HttpStatus.OK);
	}

	@GetMapping("/deleteBuildingDepartmentDB/{id}")
	public ResponseEntity<Response> deleteBuildingDepartmentDB(@PathVariable("id") Long id) {
		if (id != null) {
			BuildingDepartmentDB addressDB = departmentDBService.getBuildingDepartmentDB(id);
			departmentDBService.delete(addressDB.getBuildingDepartmentDBId());
			return new ResponseEntity<Response>(new Response("this Category deleted successfully"), HttpStatus.OK);
		} else {
			return null;
		}
	}

	@GetMapping("/getBuildingDepartmentDB/{id}")
	public ResponseEntity<BuildingDepartmentDB> getBuildingDepartmentDB(@PathVariable("id") Long id) {
		if (id != null) {
			BuildingDepartmentDB addressDB = departmentDBService.getBuildingDepartmentDB(id);
			return new ResponseEntity<BuildingDepartmentDB>(addressDB, HttpStatus.OK);
		} else {
			return null;
		}
	}
}
