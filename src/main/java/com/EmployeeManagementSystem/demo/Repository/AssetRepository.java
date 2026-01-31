package com.EmployeeManagementSystem.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EmployeeManagementSystem.demo.Entity.Asset;

public interface AssetRepository extends JpaRepository<Asset, Integer> {}

