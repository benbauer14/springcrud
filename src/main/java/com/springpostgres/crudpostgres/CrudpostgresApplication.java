package com.springpostgres.crudpostgres;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springpostgres.crudpostgres.dao.StudentDAO;
import com.springpostgres.crudpostgres.entity.Student;

@SpringBootApplication
public class CrudpostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudpostgresApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);
			// createMultipleStudents(studentDAO);
			// getStudent(studentDAO);
			// queryForStudents(studentDAO);
			// queryForStudentsByLastName(studentDAO);
			updateStudent(studentDAO);
			
		};
	}

	private void updateStudent(StudentDAO studentDAO) {

		// get the student
		System.out.println("Getting the student");
		Student student = studentDAO.findById(3);
		System.out.println("Retrieved student: " + student);

		// update the student
		System.out.println("Updating the student");
		student.setEmail("pan@neverland.com");

		// save the updated student
		studentDAO.update(student);

		// get the updated student
		System.out.println("Getting the updated student");
		Student updatedStudent = studentDAO.findById(3);
		System.out.println("Updated student: " + updatedStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get all students

		System.out.println("Getting all students with last name Pan");
		List<Student>  theStudents = studentDAO.findByLastName("Pan");
		// Print each student
		theStudents.forEach(System.out::println);
		
		// alternative
		// for (Student student : theStudents) {
		// 	System.out.println(student);
		//
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get all students

		System.out.println("Getting all students");
		List<Student>  theStudents = studentDAO.findAll();
		// Print each student
		theStudents.forEach(System.out::println);
		
		// alternative
		// for (Student student : theStudents) {
		// 	System.out.println(student);
		// }
	}

	private void getStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating a new student object");
		Student student = new Student("Captain", "Hook", "hook@neverland.com");

		// save the student object
		System.out.println("Saving the student");
		studentDAO.save(student);

		// display the id of the saved student
		System.out.println("Saved student. Generated id: " + student.getId());

		// get the student object
		System.out.println("Getting the student");
		Student retrievedStudent = studentDAO.findById(student.getId());
		System.out.println("Retrieved student: " + retrievedStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple student objects
		System.out.println("Creating multiple student objects");
		Student student1 = new Student("Peter", "Pan", "pan@neverland.com");
		Student student2 = new Student("Wendy", "Darling", "wendy@neverland.com");
		Student student3 = new Student("John", "Darling", "john@neverland.com");	
		
		
		// save the student objects
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);


		
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating a new student object");
		Student student = new Student("Tinker", "Bell", "tink@neverland.com");


		//save the student object
		System.out.println("Saving the student");
		studentDAO.save(student);

		//display the id of the saved student
		System.out.println("Saved student. Generated id: " + student.getId());
	}

}
