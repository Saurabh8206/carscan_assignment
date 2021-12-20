package com.carscan.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.carscan.model.UsersEntity;

/**
 * @author Saurabh Kohade
 * 
 *         User service class which defines the service and operations to be
 *         performed by this application.
 *
 */
@Service
public interface UserService {

	List<UsersEntity> getAllUsers();

	UsersEntity createUser(UsersEntity post);

	UsersEntity editUser(long userId, UsersEntity post);

	void deleteUser(long userId);

	UsersEntity getUserByuserId(long userId);

}
