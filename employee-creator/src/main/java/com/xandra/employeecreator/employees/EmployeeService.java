package com.xandra.employeecreator.employees;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;
	
	@Autowired
	private ModelMapper mapper;

	public Employee createEmployee(CreateEmployeeDTO data) {
		//System.out.println(data);
		//BUSINESS LOGIC GOES HERE, before instance of Employee is saved to database
		
//		Employee newEmployee = new Employee();
//		return "at service layer";
		
		Employee newEmployee = mapper.map(data, Employee.class);
		return this.repo.save(newEmployee);
	}

	public List<Employee> getAll() {
		return this.repo.findAll();
	}

	public Optional<Employee> findById(Long id) {
		return this.repo.findById(id);
	}

	public Optional<Employee> updateById(@Valid UpdateEmployeeDTO data, Long id) {
		Optional<Employee> maybeEmployee = this.findById(id);
		
		if (maybeEmployee.isEmpty()) {
			return maybeEmployee;
		}
		
		Employee foundEmployee = maybeEmployee.get();
		
		mapper.map(data,  foundEmployee);
		
		Employee updatedEmployee = this.repo.save(foundEmployee);
		return Optional.of(updatedEmployee);
	}

	public boolean deleteTaskById(Long id) {
		Optional<Employee> maybeEmployee = this.repo.findById(id);
		if (maybeEmployee.isEmpty()) {
			return false;
		}
		this.repo.delete(maybeEmployee.get());
		return true;
	}

}
