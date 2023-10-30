package com.example.springboot.employeedemo.rest;

import com.example.springboot.employeedemo.entity.Employee;
import com.example.springboot.employeedemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {

        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found -> " + employeeId);
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        // if user passes an id in json, set it to 0
        // this is to force saving item instead of updating, if user passes an id and performs post, it will b updated
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
        // dbEmployee has id of new employee added (added employee)
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee = employeeService.findById(employeeId);
        // if id given is wrong, we cant delete that employee so simply return exception
        if(tempEmployee == null){
            throw new RuntimeException("Employee id not found -> " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted employee with id ->" + employeeId;
    }
}