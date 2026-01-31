package com.EmployeeManagementSystem.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagementSystem.demo.Entity.Asset;
import com.EmployeeManagementSystem.demo.Entity.Employee;
import com.EmployeeManagementSystem.demo.Repository.AssetRepository;
import com.EmployeeManagementSystem.demo.Repository.EmployeeRepository;


@Service
public class AssetService {

    @Autowired
    private AssetRepository assetRepo;

    @Autowired
    private EmployeeRepository employeeRepo;

    public List<Asset> getAll() {
        return assetRepo.findAll();
    }

    public Asset getById(int id) {
        return assetRepo.findById(id).orElse(null);
    }

    public Asset add(Asset asset, int empId) {
        Employee emp = employeeRepo.findById(empId).orElse(null);
        asset.setEmployee(emp);
        return assetRepo.save(asset);
    }

    public Asset update(int id, Asset a) {
        Asset asset = assetRepo.findById(id).orElse(null);
        asset.setAssetName(a.getAssetName());
        asset.setAssetType(a.getAssetType());
        return assetRepo.save(asset);
    }

    public void delete(int id) {
        assetRepo.deleteById(id);
    }
}
