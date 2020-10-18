package com.wellsfargo.fsd.it.Model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserModel {
	
	@NotNull(message = "User id is mandatory is mandatory")
	@Min(value=1,message = "User id cannot be negative or zero")
	private Integer userId;
	
	@NotNull(message = "firstName is mandatory")
	@Size(min=5,max=30,message = "firstName is expected to be 5 to 30 chars in length")
	private String firstName;
	
	@NotNull(message = "lastName is mandatory")	
	@Size(min=3,max=25,message = "lastName is expected to be 3 to 30 chars in length")
	private String lastName;
	
	@NotNull(message = "email is mandatory")
	@Email(message = "Please enter valid email ID")
	private String email;
	
	@NotNull(message = "mobile is mandatory")
	@Size(min=10,max=10,message = "Mobile should be of 10 chars")
	private String mobile;
	

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public UserModel(Integer userId, String firstName, String lastName, String email, String mobile) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
	}
	public UserModel(String firstName, String lastName, String email, String mobile) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
	}
	public UserModel() {
		super();
	}
	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", mobile=" + mobile + "]";
	}
	
	

}
