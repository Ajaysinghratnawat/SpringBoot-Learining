package com.ajay.RestAndMVC.repositories;

import com.ajay.RestAndMVC.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
    
}
