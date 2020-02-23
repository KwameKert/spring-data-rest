package com.codeinsyt.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeinsyt.springboot.cruddemo.dao.EmployeeRepository;
import com.codeinsyt.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImp(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	
	@Override
	public List<Employee> listEmployees() {
		return this.employeeRepository.findAll();
		
	}

	@Override
	public Employee getEmployee(long id) {
		Optional<Employee> result = this.employeeRepository.findById(id);
		
		Employee theEmployee = null;
		
		if(result.isPresent()) {
			theEmployee = result.get();
		}else {
			throw new RuntimeException("Employee not found");
		}
		
		return theEmployee;
		
	}

	@Override
	public void save(Employee employee) {
		this.employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(long id) {
		this.employeeRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

}
