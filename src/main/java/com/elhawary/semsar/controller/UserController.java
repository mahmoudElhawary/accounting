package com.elhawary.semsar.controller;

import java.io.IOException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.elhawary.semsar.model.User;
import com.elhawary.semsar.service.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class UserController {

	@Autowired
	private UserService userService ;
	
	@GetMapping("/getUsers")
	public ResponseEntity<Iterable<User>> getUsers() {
		Iterable<User>users=userService.getUsers() ;
		return new ResponseEntity<Iterable<User>>(users , HttpStatus.OK) ;
	}
	@GetMapping("/findUserById/{id}")
	public ResponseEntity<User> findUserById(@PathVariable("id") Long id) {
		User user=userService.findOne(id) ;
		return new ResponseEntity<User>(user , HttpStatus.OK) ;
	}
	@GetMapping("/getUser")
	public ResponseEntity<User> getUser(Principal principal) {
		User user = userService.getUserByEmail(principal.getName()) ;
		return new ResponseEntity<User>(user, HttpStatus.OK) ;
	}
	
	@PostMapping("/updatePhoto")
	public ResponseEntity<User> updatePhoto(@RequestParam("id") String id,
			@RequestParam("userFile") MultipartFile userFile) throws JsonParseException, JsonMappingException, IOException {
		// get product data from rest api
		if (id != null) {
			long userId = new ObjectMapper().readValue(id, Long.class) ;
			User userData = userService.findOne(userId);
			userData.setUserPhoto(userFile.getBytes());
			userService.save(userData);
			User user = userService.findOne(userData.getId()) ;
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			return null;
		}
	}
//	@PostMapping("/updateUser")
//	public ResponseEntity<User> updateUser(@RequestParam("email") String id,
//			@RequestParam("user") String user) throws JsonParseException, JsonMappingException, IOException {
//		// get product data from rest api
//		if (id != null) {
//			String email = new ObjectMapper().readValue(id, String.class) ;
//			User userOldData =new ObjectMapper().readValue(user, User.class) ;
//			User userData = userService.getUserByEmail(email);
//			userData.setUserPhoto(userOldData.getUserPhoto());
//			userData.setAge(userOldData.getAge());
//			userData.setEnabled(true);
//			userData.setFirstName(userOldData.getFirstName());
//			userData.setLastName(userOldData.getLastName());
//			userData.setGender(userOldData.getGender());
////			userData.setPassword(userOldData.getPassword());
//			userData.setRole(userOldData.getRole());
//			userData.setUpdatedDate(new Date());
//			userData.setUserAdresses(userOldData.getUserAdresses());
//			userData.setUserSocialMedias(userOldData.getUserSocialMedias());
//			userService.save(userData);
//			User userResponse = userService.getUserByEmail(userData.getEmail()) ;
//			return new ResponseEntity<User>(userResponse, HttpStatus.OK);
//		} else {
//			return null;
//		}
//	}
}
