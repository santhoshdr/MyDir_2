package org.directory.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.directory.event.BaseEvent;

public class RegistrationInfoData  extends BaseEvent{


	public RegistrationInfoData(){

	}


	public RegistrationInfoData(String eventName) {
		super(eventName);
		// TODO Auto-generated constructor stub
	}
	private String name;
	private String firstName;
	private String lastName;

	private String sex;
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the married
	 */
	public boolean isMarried() {
		return married;
	}
	/**
	 * @param married the married to set
	 */
	public void setMarried(boolean married) {
		this.married = married;
	}
	/**
	 * @return the occupation
	 */
	public String getOccupation() {
		return occupation;
	}
	/**
	 * @param occupation the occupation to set
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	private boolean married;

	private String email;
	private int age;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date dob;
	private String mobile;
	private String city;
	private String query;
	private String company;
	private String occupation;




	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}




}
