package com.carscan.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carscan.carscandto.UserDto;
import com.carscan.model.UsersEntity;
import com.carscan.services.UserService;

/**
 * @author Saurabh Kohade
 * 
 *         Controller class for handlers. All opertaions for Users :
 *         CREATE,EDIT,DELETE,
 *
 */
@RestController
@RequestMapping(path = "/api")
public class UserApi {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserService service;

	/**
	 * @return List of users in database
	 */
	@GetMapping(path = "/users")
	public List<UserDto> getUsers() {
		try {
			return service.getAllUsers().stream().map(user -> modelMapper.map(user, UserDto.class))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("EXCEPTION IN CLASS" + this.getClass().getName() + "--->" + e);
			return List.of();
		}

	}


//	{
//	    "userId": 1,
//	    "dob": "2021-12-20T19:19:25.030+00:00",
//	    "country": "India",
//	    "state": "MH",
//	    "city": "Pune",
//	    "mobile": "7030479668",
//	    "email": "skohade1@gmail.com",
//	    "address": "Kiran Solitaire",
//	    "userCreatedOn": "2021-12-20T19:19:25.030+00:00",
//	    "fname": "Saurabh",
//	    "lname": "kohade"
//	}
	/**
	 * @param UserEntity
	 * 
	 * The handler creates the new fresh user in UsersEntity.
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<UsersEntity> createUser(@RequestBody UsersEntity entity) {

		try {
			service.createUser(entity);
			return new ResponseEntity<UsersEntity>(entity, HttpStatus.CREATED);

		} catch (Exception e) {
			System.out.println("EXCEPTION IN CLASS" + this.getClass().getName() + "--->" + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}

	}

	/**
	 * @param userId
	 * @param entity
	 * 
	 * Update/Edit the users details by fetching its record by userId(PK)
	 * 
	 */
	@PutMapping(path = "/edit/{userId}")
	public ResponseEntity<UsersEntity> editUser(@PathVariable long userId, @RequestBody UsersEntity entity) {

		try {
			service.editUser(userId, entity);
			return new ResponseEntity<UsersEntity>(entity, HttpStatus.OK);

		} catch (Exception e) {
			System.out.println("EXCEPTION IN CLASS" + this.getClass().getName() + "--->" + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}

	}

	/**
	 * @param userId
	 * 
	 * Deletes the record of user of user by particular userId
	 */
	@DeleteMapping(path = "/delete/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable long userId) {

		try {
			service.deleteUser(userId);
			return  ResponseEntity.status(200).body("User Deleted");

		} catch (Exception e) {
			System.out.println("EXCEPTION IN CLASS :: " + this.getClass().getName() + "--->" + e);
			return ResponseEntity.status(400).body("EXCEPTION IN CLASS :: " + this.getClass().getName() + "--->" + e);

		}

	}
}
