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

import com.EmployeeManagementSystem.demo.Entity.Asset;
import com.EmployeeManagementSystem.demo.Service.AssetService;

@RestController
@RequestMapping("/api/assets")
@CrossOrigin(origins = "http://localhost:3000")
public class AssetController {

    @Autowired
    AssetService service;

    @GetMapping("/getAll")
    public List<Asset> getAll() {
        return service.getAll();
    }

    @GetMapping("/getById/{id}")
    public Asset getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping("/add/{empId}")
    public Asset add(@RequestBody Asset a, @PathVariable int empId) {
        return service.add(a, empId);
    }

    @PutMapping("/update/{id}")
    public Asset update(@PathVariable int id, @RequestBody Asset a) {
        return service.update(id, a);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
