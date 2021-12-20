package com.carscan.seerviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carscan.crconstants.ResourceNotFoundException;
import com.carscan.model.UsersEntity;
import com.carscan.repository.UserRepo;
import com.carscan.services.UserService;

/**
 * @author Saurabh Kohade
 * 
 *         The service implementation class for the operations.
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo uobj_repo;

	@Override
	public List<UsersEntity> getAllUsers() {
		try {
			return uobj_repo.findAll();
		} catch (Exception e) {
			System.out.println("EXCEPTION IN CLASS" + this.getClass().getName() + "--->" + e);
			return List.of();
		}
	}

	@Override
	public UsersEntity createUser(UsersEntity user) {
		try {
			if (user != null) {
				return uobj_repo.save(user);
			}
		} catch (Exception e) {
			System.out.println("EXCEPTION IN CLASS" + this.getClass().getName() + "--->" + e);
		}
		return user;

	}

	@Override
	public UsersEntity editUser(long userId, UsersEntity user) {
		UsersEntity entity = null;
		if (user != null) {

			entity = getUserByuserId(userId);

//			ModelMapper modelMapper = new ModelMapper();

			if (entity != null) {
//				modelMapper.map(user, entity);
				entity = uobj_repo.save(user);
			}

		} else {
			throw new IllegalArgumentException("Request Entity is Null");
		}
		return entity;

	}

	@Override
	public void deleteUser(long userId) {

		try {
			if (uobj_repo.existsById(userId)) {
				uobj_repo.deleteById(userId);
			} else {
				throw new ResourceNotFoundException(
						"Could not delete the record withe Id " + userId + ". Id was not found.");
			}
		} catch (Exception e) {
			System.out.println("EXCEPTION IN CLASS" + this.getClass().getName() + "--->" + e);
		}

	}

	@Override
	public UsersEntity getUserByuserId(long userId) {

		try {
			Optional<UsersEntity> result = uobj_repo.findById(userId);

			if (result.isPresent()) {
				return result.get();
			} else {
				throw new ResourceNotFoundException("Could not find a record with Id " + userId);
			}
		} catch (Exception e) {
			System.out.println("EXCEPTION IN CLASS" + this.getClass().getName() + "--->" + e);
			return null;
		}

	}

}
