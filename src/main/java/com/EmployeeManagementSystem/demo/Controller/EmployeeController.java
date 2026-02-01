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

import com.EmployeeManagementSystem.demo.Entity.Employee;
import com.EmployeeManagementSystem.demo.Service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping("/getAll")
    public List<Employee> getAll() {
        return service.getAll();
    }

    @GetMapping("/getById/{id}")
    public Employee getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping("/add/{deptId}")
    public Employee add(@RequestBody Employee e, @PathVariable int deptId) {
        return service.add(e, deptId);
    }
    
    @PutMapping("/update/{id}")
    public Employee update(@PathVariable int id, @RequestBody Employee e) {
        return service.update(id, e);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
