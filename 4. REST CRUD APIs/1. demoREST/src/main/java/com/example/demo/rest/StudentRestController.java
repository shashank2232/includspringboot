package com.example.demo.rest;

import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    // defining list here instead of making list in each methods below
    private List<Student> theStudents;
    // use @PostConstruct to load student data, @PostConstruct is called only once when given bean is constructed
    // by this we wont need to create student data list in each different methods
    // just once created and we can use them to retrieve/manipulate data everywhere in our controller, due to this approach we only load student data once
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Shashank","Mishra"));
        theStudents.add(new Student("Parthik","Patel"));
        theStudents.add(new Student("Nikhil","Thakur"));
    }

    // this method is returning List of type Students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }


    // @PathVariable int studentId -> this will bind that path variable coming in from URL to this variable studentId
    // by default both of their names must match up i.e. URL pathname and variable name in path variable must be same
    @GetMapping("/students/{studentId}")
    public Student oneStudent(@PathVariable int studentId){
        // if studentId is less than 0 or greater equal to List<Student> size, means its not present, bad data
        if(studentId >= theStudents.size() || studentId < 0){
            throw new StudentNotFoundException("Student id not found -> " + studentId);
        }

        return theStudents.get(studentId);
    }

    // in above method we were throwing exception but not handling it, below we'll handle it too
    // StudentErrorResponse is the Response type, and StudentNotFoundException is exception type
    // i.e. this method will catch StudentNotFoundException
   /* @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        // create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity , error is body of Response & status_code, the message i.e. error StudentErrorResponse will be shown in message body and status code will be shown near browser icon
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    // on giving studentId 999, we get message -> { "status": 404, "message": "Student id not found -> 999", "timeStamp": 1698048058225}

    // adding another exception handler to catch any type of exception eg. string, here we'll be handling generic Exception, above was for the StudentNotFoundException
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
//        error.setMessage("SYSTUMMMM");
        error.setMessage(exc.getMessage());             // gives exception message by itself
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    */


}
