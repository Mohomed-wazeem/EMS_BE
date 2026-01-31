package com.EmployeeManagementSystem.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagementSystem.demo.Entity.Department;
import com.EmployeeManagementSystem.demo.Entity.Employee;
import com.EmployeeManagementSystem.demo.Repository.DepartmentRepository;
import com.EmployeeManagementSystem.demo.Repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private DepartmentRepository departmentRepo;

    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }

    public Employee getById(int id) {
        return employeeRepo.findById(id).orElse(null);
    }

    public Employee add(Employee emp, int deptId) {
        Department dept = departmentRepo.findById(deptId).orElse(null);
        emp.setDepartment(dept);
        return employeeRepo.save(emp);
    }

    public Employee update(int id, Employee emp) {
        Employee e = employeeRepo.findById(id).orElse(null);
        e.setName(emp.getName());
        e.setSalary(emp.getSalary());
        return employeeRepo.save(e);
    }

    public void delete(int id) {
        employeeRepo.deleteById(id);
    }
}
