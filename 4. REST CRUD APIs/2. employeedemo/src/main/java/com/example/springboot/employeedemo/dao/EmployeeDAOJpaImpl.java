package com.example.springboot.employeedemo.dao;

import com.example.springboot.employeedemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    // define field for entitymanager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    // note: entitymanager is auto-created in springboot, we inject it
    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        Employee employee = entityManager.find(Employee.class,theId);  // get employee
        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        // save employee
        Employee dbemployee = entityManager.merge(theEmployee);
        // merge performs a save/update depending on id, if id is 0 then insert it else just update it
        return dbemployee;
        // dbemployee has updated id from db
    }

    @Override
    public void deleteById(int theId) {
        // find employee
        Employee deleteEmployee = entityManager.find(Employee.class,theId);
        // remove it
        entityManager.remove(deleteEmployee);
    }
}

// @Transactional will be handled at Service layer, so no need to use in DAO