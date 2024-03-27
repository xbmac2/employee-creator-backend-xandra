package com.xandra.employeecreator.employees;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xandra.employeecreator.exceptions.BadRequestException;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;
	
	@Autowired
	private ModelMapper mapper;

	public Employee createEmployee(CreateEmployeeDTO data) throws BadRequestException {

		if (data.getContractType() == ContractType.valueOf("CONTRACT")) {
			if (data.getFinishDate() == null) throw new BadRequestException("Contract Type");
		}
		
		if (data.getContractType() == ContractType.valueOf("PERMANENT")) {
			if (data.getFinishDate() != null) throw new BadRequestException("Contract Type");
		}
		
		if (data.getFinishDate() != null) {
			if (data.getFinishDate().getTime() < data.getStartDate().getTime()) throw new BadRequestException("Finish date");
		}
		
		Employee newEmployee = mapper.map(data, Employee.class);
		return this.repo.save(newEmployee);
	}

	public List<Employee> getAll() {
		return this.repo.findAll();
	}

	public Optional<Employee> findById(Long id) {
		return this.repo.findById(id);
	}

	public Optional<Employee> updateById(@Valid UpdateEmployeeDTO data, Long id) throws BadRequestException {
		//business logic; contract type and start/end date validation
		if (data.getContractType() == ContractType.valueOf("CONTRACT")) {
			if (data.getFinishDate() == null) throw new BadRequestException("Contracted employees must have a finish date");
		}
		
		if (data.getContractType() == ContractType.valueOf("PERMANENT")) {
			if (data.getFinishDate() != null) throw new BadRequestException("Permanent employees must not have a finish date");
		}
		
		if (data.getFinishDate() != null) {
			if (data.getFinishDate().getTime() < data.getStartDate().getTime()) throw new BadRequestException("Finish date must be after the start date");
		}
		
		Optional<Employee> maybeEmployee = this.findById(id);
		
		if (maybeEmployee.isEmpty()) {
			return maybeEmployee;
		}
		
		Employee foundEmployee = maybeEmployee.get();
		
		mapper.map(data, foundEmployee);
		
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
