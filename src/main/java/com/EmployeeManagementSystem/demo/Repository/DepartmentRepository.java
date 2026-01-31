package com.EmployeeManagementSystem.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EmployeeManagementSystem.demo.Entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {}

