package com.xandra.employeecreator.employees;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xandra.employeecreator.exceptions.BadRequestException;
import com.xandra.employeecreator.exceptions.NotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody CreateEmployeeDTO data) throws BadRequestException {
		System.out.println(data);
		//return "YOU created an employee";
		//return this.employeeService.createEmployee(data);
		
		Employee createdEmployee = this.employeeService.createEmployee(data);
		return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> allEmployees = this.employeeService.getAll();
		return new ResponseEntity<>(allEmployees, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws NotFoundException {
		Optional<Employee> maybeEmployee = this.employeeService.findById(id);
		
		Employee foundEmployee = maybeEmployee.orElseThrow(() -> new NotFoundException(Employee.class, id));
		return new ResponseEntity<>(foundEmployee, HttpStatus.OK);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@Valid @RequestBody UpdateEmployeeDTO data, @PathVariable Long id) throws NotFoundException, BadRequestException {
		Optional<Employee> maybeUpdatedEmployee = this.employeeService.updateById(data, id);
		
		Employee updatedEmployee = maybeUpdatedEmployee.orElseThrow(() -> new NotFoundException(Employee.class, id));
		
		return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> deleteEmployeeById(@PathVariable Long id) throws NotFoundException {
		boolean deleted = this.employeeService.deleteTaskById(id);
		if (!deleted) {
			throw new NotFoundException(Employee.class, id);
		}
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
}
