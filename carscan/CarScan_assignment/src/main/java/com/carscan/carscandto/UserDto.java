package com.carscan.carscandto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Saurabh Kohade
 * 
 * DTO class for Users details. 
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private long userId;
	private String fName;
	private String lName;
	private Date dob;
	private String city;
	private String mobile;

}
