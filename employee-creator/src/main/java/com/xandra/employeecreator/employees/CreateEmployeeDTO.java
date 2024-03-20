package com.xandra.employeecreator.employees;

import java.util.Date;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class CreateEmployeeDTO {
	
	@NotBlank
	private String firstName;
	
	private String middleName;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
	flags = Pattern.Flag.CASE_INSENSITIVE)
	private String email;
	
	@NotBlank
	@Pattern(regexp="(^$|[0-9]{10})")
	private String mobileNumber;
	
	@NotBlank
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

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public ContractType getContractType() {
		return contractType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public Boolean getIsOngoing() {
		return isOngoing;
	}

	public Integer getHoursPerWeek() {
		return hoursPerWeek;
	}

	@Override
	public String toString() {
		return "CreateEmployeeDTO [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", email=" + email + ", mobileNumber=" + mobileNumber + ", address=" + address + ", contractType="
				+ contractType + ", startDate=" + startDate + ", finishDate=" + finishDate + ", isOngoing=" + isOngoing
				+ ", hoursPerWeek=" + hoursPerWeek + "]";
	}
	
	
}
