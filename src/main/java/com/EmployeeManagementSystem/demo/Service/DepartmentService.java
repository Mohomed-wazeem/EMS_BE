package com.EmployeeManagementSystem.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagementSystem.demo.Entity.Department;
import com.EmployeeManagementSystem.demo.Repository.DepartmentRepository;
import java.util.List;


@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repo;

    public List<Department> getAll() {
        return repo.findAll();
    }

    public Department getById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Department add(Department d) {
        return repo.save(d);
    }

    public Department update(int id, Department d) {
        Department dept = repo.findById(id).orElse(null);
        dept.setName(d.getName());
        dept.setLocation(d.getLocation());
        return repo.save(dept);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
