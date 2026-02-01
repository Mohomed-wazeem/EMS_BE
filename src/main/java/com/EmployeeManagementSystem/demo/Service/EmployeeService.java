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
    

    public Employee update(int id, Employee e) {
        Employee emp = employeeRepo.findById(id).get();
        emp.setName(e.getName());
        emp.setSalary(e.getSalary());

        if (e.getDepartment() != null) {
            emp.setDepartment(
                departmentRepo.findById(e.getDepartment().getId()).get()
            );
        }
        return employeeRepo.save(emp);
    }


    public void delete(int id) {
        employeeRepo.deleteById(id);
    }
}
