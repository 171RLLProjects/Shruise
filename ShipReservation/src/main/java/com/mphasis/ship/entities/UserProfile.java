package com.mphasis.ship.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import com.mphasis.ship.util.StringPrefixedSequenceIdGenerator;

@Entity
public class UserProfile {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "user_seq")
	@GenericGenerator(name = "user_seq", 
	        strategy = "com.mphasis.ship.util.StringPrefixedSequenceIdGenerator", 
	        parameters = {
	        		@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "4"),
	        		 @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "US_"),
	        		 @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d") })
	private String userId;
	@Column(length=20,nullable=false)
	private String userName;
	@Column(length=10,nullable=false)
	private String pass;
	@Column(length=10,nullable=false)
	private String gender;
	@Column(length=8,nullable=false)
	private String role;
	@Column(length=10,nullable=false)
	private long phoneNo;
	@Column(length=50,nullable=false)
	private String address;
	private int age;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
