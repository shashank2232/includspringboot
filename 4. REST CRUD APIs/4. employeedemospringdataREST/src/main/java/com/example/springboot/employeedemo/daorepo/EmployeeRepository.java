package com.example.springboot.employeedemo.daorepo;

import com.example.springboot.employeedemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// spring data will use /members instead of /employees
// @RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
