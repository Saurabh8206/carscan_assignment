package com.carscan.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Saurabh Kohade
 * 
 * User Entity class
 *
 */
@Entity
@Table(name = "tbl_carscan_users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsersEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "UserId", nullable = false)
	private long userId;

	@Column(name = "FirstName")
	private String fName;

	@Column(name = "LastName")
	private String lName;
	
	@Column(name = "DateOfBirth")
	private Date dob;
	
	@Column(name = "Country")
	private String country;
	
	@Column(name = "State")
	private String state;
	
	@Column(name = "City")
	private String city;
	
	@Column(name = "MobileNo")
	private String mobile;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Address")
	private String address;
	
	private Date userCreatedOn;

}
