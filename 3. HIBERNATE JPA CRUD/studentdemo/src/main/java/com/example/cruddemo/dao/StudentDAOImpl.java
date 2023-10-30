package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

// this is a specialized annotation for repositories, gives support for component scanning, also translates jdbc exceptions
@Repository
public class StudentDAOImpl implements StudentDAO{
    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save() method
    @Override
    @Transactional
    public void save(Student theStudent) {
        // this will save student to the database
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        // finding id(primary key) Entity class Student
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query , here Student is JPA entity i.e. class name, not db table
//        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student",Student.class);

        // to get list in order of lastName, by default it will sort ascending
        // for descending -> ORDER BY lastName DESC
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student ORDER BY lastName",Student.class);

        // return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

        // set query parameters
        theQuery.setParameter("theData", theLastName);
        // passing theLastName to search students with given lastName

        // return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        // retrieve the student
        Student myStudent = entityManager.find(Student.class,id);

        // delete student
        entityManager.remove(myStudent);
    }


//    @Override
//    @Transactional
//    public int deleteAll() {
//        int numOfRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
//        return numOfRowsDeleted;
//    }
}
