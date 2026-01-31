package com.EmployeeManagementSystem.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeManagementSystem.demo.Entity.Department;
import com.EmployeeManagementSystem.demo.Service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin(origins = "http://localhost:3000")
public class DepartmentController {

    @Autowired
    DepartmentService service;

    @GetMapping("/getAll")
    public List<Department> getAll() {
        return service.getAll();
    }

    @GetMapping("/getById/{id}")
    public Department getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping("/add")
    public Department add(@RequestBody Department d) {
        return service.add(d);
    }

    @PutMapping("/update/{id}")
    public Department update(@PathVariable int id, @RequestBody Department d) {
        return service.update(id, d);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
