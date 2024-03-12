package com.xandra.employeecreator.employees;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String firstName;
	
	@Column(nullable=true)
	private String middleName;
	
	@Column
	private String lastName;
	
	@Column
	private String email;
	
	@Column
	private Number mobileNumber;
	
	@Column
	private String address;
	
	
	@Column
	private Date startDate;
	
	@Column(nullable=true)
	private Date finishDate;
	
	@Column
	private Boolean isOngoing;
	
	@Column
	private Integer hoursPerWeek;

}
