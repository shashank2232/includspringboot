package com.example.springboot.employeedemo.service;

import com.example.springboot.employeedemo.dao.EmployeeDAO;
import com.example.springboot.employeedemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDAO employeeDAO;

    // not imp but still for practice
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
        employeeDAO=theEmployeeDAO;
    }
    @Override
    public List<Employee> findAll() {
        // simply use DAO calls for methods since DAO have the implementation, we just use it
        return employeeDAO.findAll();
    }
    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }
}
