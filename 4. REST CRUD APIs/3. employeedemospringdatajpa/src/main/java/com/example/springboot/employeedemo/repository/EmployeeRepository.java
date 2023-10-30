package com.example.springboot.employeedemo.repository;

import com.example.springboot.employeedemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
