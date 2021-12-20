package com.carscan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carscan.model.UsersEntity;

/**
 * @author Saurabh Kohade
 *
 * The repository implementation to overcome with JPA method by JPARepository.
 * Using JPAs predefined methods. 
 */
public interface UserRepo extends JpaRepository<UsersEntity , Long>{

}
