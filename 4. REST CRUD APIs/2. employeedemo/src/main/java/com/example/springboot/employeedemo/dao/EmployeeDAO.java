package com.example.springboot.employeedemo.dao;

import com.example.springboot.employeedemo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);
}
