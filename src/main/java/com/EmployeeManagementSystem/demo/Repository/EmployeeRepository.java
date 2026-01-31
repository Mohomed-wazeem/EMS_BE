package com.EmployeeManagementSystem.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EmployeeManagementSystem.demo.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}

