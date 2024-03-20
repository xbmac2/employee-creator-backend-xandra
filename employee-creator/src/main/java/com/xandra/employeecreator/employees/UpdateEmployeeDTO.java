package com.xandra.employeecreator.employees;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public class UpdateEmployeeDTO {
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
	flags = Pattern.Flag.CASE_INSENSITIVE)
	private String email;
	
	@Pattern(regexp="(^$|[0-9]{10})")
	private String mobileNumber;
	
	private String address;
	
	//@NotBlank this enum cannot use notblank
	private ContractType contractType;
	
	//@NotBlank Date cannot use notblank??
	private Date startDate;
	
	//@NotBlank
	private Date finishDate;
	
	//@NotBlank booleans cannot use notblank??
	private Boolean isOngoing;
	
	//@NotBlank
	private Integer hoursPerWeek;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ContractType getContractType() {
		return contractType;
	}

	public void setContractType(ContractType contractType) {
		this.contractType = contractType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public Boolean getIsOngoing() {
		return isOngoing;
	}

	public void setIsOngoing(Boolean isOngoing) {
		this.isOngoing = isOngoing;
	}

	public Integer getHoursPerWeek() {
		return hoursPerWeek;
	}

	public void setHoursPerWeek(Integer hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}
	
	
}
