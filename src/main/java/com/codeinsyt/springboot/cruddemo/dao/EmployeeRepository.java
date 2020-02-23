package com.codeinsyt.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeinsyt.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
