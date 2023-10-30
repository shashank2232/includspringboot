package com.example.springboot.employeedemo.service;

import com.example.springboot.employeedemo.entity.Employee;
import com.example.springboot.employeedemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    // not imp but still for practice
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository=theEmployeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        // simply use DAO calls for methods since DAO have the implementation, we just use it
        return employeeRepository.findAll();
    }
    @Override
    public Employee findById(int theId) {
//   Optional is used to represent a value that may or may not be present
//   NullPointerException. It can crash your code. And it is very hard to avoid it without using too many null checks.
//   By using Optional, we can specify alternate values to return or alternate code to run.
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee = null;
        if(result.isPresent()){
            theEmployee = result.get();       // theEmployee contains employee data
        }
        else{
            // if employee of given id not found
            throw new RuntimeException("Did not find employee id -> " + theId);
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
