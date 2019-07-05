package com.elhawary.semsar.controller.admin;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.elhawary.semsar.model.BuildingComment;
import com.elhawary.semsar.model.Buildings;
import com.elhawary.semsar.model.User;
import com.elhawary.semsar.repository.BuildingCommentRepository;
import com.elhawary.semsar.service.BuildingsService;
import com.elhawary.semsar.service.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class BuildingCommentController {

	@Autowired
	private UserService userService;
	@Autowired
	private BuildingsService buildingsService;

	@Autowired
	private BuildingCommentRepository buildingCommentRepository;

	@PostMapping(value = "/addBuildingComment")
	public ResponseEntity<List<BuildingComment>> addBuildingComment(@RequestParam("building") String building,
			@RequestParam("comment") String comment, @RequestParam("id") String idd)
			throws JsonParseException, JsonMappingException, IOException {
		if ((building != null) || (comment != null)) {
			Buildings buildingData = new ObjectMapper().readValue(building, Buildings.class);
			BuildingComment buildingComment = new ObjectMapper().readValue(comment, BuildingComment.class);
			long id = new ObjectMapper().readValue(idd, Long.class);
			User user = userService.findOne(id);
			buildingComment.setCommentDate(new Date());
			buildingComment.setUser(user);
			buildingComment.setCommentCount(buildingComment.getCommentCount() + 1);
			Buildings buildingValue = buildingsService.findById(buildingData.getBuildingsId());
			buildingComment.setBuildings(buildingValue);
			buildingCommentRepository.save(buildingComment);
			Buildings productResponse = buildingsService.findById(buildingData.getBuildingsId());
			List<BuildingComment> comments = buildingCommentRepository
					.findAllByBuildingsBuildingsId(productResponse.getBuildingsId());
			return new ResponseEntity<List<BuildingComment>>(comments, HttpStatus.OK);
		} else {
			return null;
		}
	}

	@PostMapping(value = "/addBuildingCommentPhoto")
	public ResponseEntity<List<BuildingComment>> addBuildingCommentPhoto(@RequestParam("building") String building,
			@RequestParam("buildingFile") MultipartFile buildingFile, @RequestParam("id") String idd)
			throws JsonParseException, JsonMappingException, IOException {
		if (building != null) {
			Buildings buildingData = new ObjectMapper().readValue(building, Buildings.class);
			long id = new ObjectMapper().readValue(idd, Long.class);
			User user = userService.findOne(id);
			BuildingComment buildingComment = new BuildingComment();
			buildingComment.setCommentPhoto(buildingFile.getBytes());
			buildingComment.setCommentDate(new Date());
			buildingComment.setUser(user);
			buildingComment.setCommentCount(buildingComment.getCommentCount() + 1);
			Buildings buildingValue = buildingsService.findById(buildingData.getBuildingsId());
			buildingComment.setBuildings(buildingValue);
			buildingCommentRepository.save(buildingComment);
			Buildings productResponse = buildingsService.findById(buildingData.getBuildingsId());
			List<BuildingComment> comments = buildingCommentRepository
					.findAllByBuildingsBuildingsId(productResponse.getBuildingsId());
			return new ResponseEntity<List<BuildingComment>>(comments, HttpStatus.OK);
		} else {
			return null;
		}
	}

	@GetMapping("/getCommentById/{id}")
	public ResponseEntity<List<BuildingComment>> getCommentById(@PathVariable("id") Long id) {
		if (id != null) {
			List<BuildingComment> comments = buildingCommentRepository.findAllByBuildingsBuildingsId(id);
			return new ResponseEntity<List<BuildingComment>>(comments, HttpStatus.OK);
		} else {
			return null;
		}
	}
}
