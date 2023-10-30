package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	//	define bean for command line runner, to create a command line app
//	this will be executed after spring beans have been loaded
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {     // injecting StudentDAO
		return runner -> {
			// createStudent(studentDAO);

			// createMultipleStudents(studentDAO);

			// readStudent(studentDAO);

			// queryForStudents(studentDAO);

			// queryForStudentsByLastName(studentDAO);

			// updateStudent(studentDAO);

			deleteStudent(studentDAO);
			
			// deleteAllStudents(studentDAO);
		};
	}

	// CREATE
	// method to create the student and save them in database
	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Shashank", "Mishra", "shashank@gmail.com");

		// save the student oject
		System.out.println("Saving the student object...");
		studentDAO.save(tempStudent);

		// display id of saved student
		System.out.println("Student saved. Generated ID: " + tempStudent.getId());
	}

	// method to create and save multiple students
	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Creating 3 student objects...");
		Student tempStudent1 = new Student("Ajay", "Kumar", "ajay@gmail.com");
		Student tempStudent2 = new Student("Rahul", "Das", "rahul@gmail.com");
		Student tempStudent3 = new Student("Kunal", "Singh", "kunal@gmail.com");

		// save them
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	// READ
	// no need to use @Transactional since we're not saving/updating database, we're only retrieving data
	// Finding student by giving a primary key say 1, and if cant find student via its primary key, simply return NULL.
	private void readStudent(StudentDAO studentDAO) {
//		// create a student
//		System.out.println("Creating new student...");
//		Student tempStudent = new Student("Sanjay", "Rathor", "sanjay@gmail.com");
//
//		// save student
//		System.out.println("Saving the student...");
//		studentDAO.save(tempStudent);
//
//		// display id of saved student
//		int theId = tempStudent.getId();
//		System.out.println("Student saved. Generated id is " + theId);
//
//		// retrieve student based on id
//		System.out.println("Retrieving student with id: " + theId);
//		Student myStudent = studentDAO.findById(theId);
//
//		// display it
//		System.out.println("Found the student: " + myStudent);

		// OR
		// instead of creating a student ourselves we can simply get student already in database by giving its id
		Student myStudent2 = studentDAO.findById(2);
		System.out.println("Found the student: " + myStudent2);

	}

	// JPQL QUERIES
	private void queryForStudents(StudentDAO studentDAO) {
		// get list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Rathor");

		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	// UPDATE
	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on id
		int studentId = 6;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);          // this will retrieve student for us

		// change firstname, lastName, email
		System.out.println("Updating student...");
		myStudent.setFirstName("Vishal");
		myStudent.setLastName("Sharma");
		myStudent.setEmail("vishal@gmail.com");

		// update the student
		studentDAO.updateStudent(myStudent);

		// display updated student
		System.out.println("Updated student: " + myStudent);
	}

	// DELETE
	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student with id: " + studentId);
		studentDAO.delete(studentId);
	}

	// DELETE ALL
//	private void deleteAllStudents(StudentDAO studentDAO){
//		System.out.println("DELETING ALL STUDENTS...");
//		int numRowsDeleted = studentDAO.deleteAll();
//		System.out.println("TOTAL ROWS DELETED: " + numRowsDeleted);
//	}

}