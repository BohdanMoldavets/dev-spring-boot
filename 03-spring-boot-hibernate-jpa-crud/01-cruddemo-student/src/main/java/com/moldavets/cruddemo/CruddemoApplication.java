package com.moldavets.cruddemo;

import com.moldavets.cruddemo.dao.StudentDAO;
import com.moldavets.cruddemo.dao.StudentDAOImpl;
import com.moldavets.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating student...");
		Student student = new Student("Sid","Nool","sid@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(student);

		System.out.println(student.getFirstName() + " student was saved. Generated ID: " + student.getId());

		System.out.println("Retrieving student...");
		Student retrivedStudent = studentDAO.findById(student.getId());

		System.out.println(retrivedStudent.toString());

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		List<Student> students = new ArrayList<>();

		System.out.println("Creating students...");
		Student student1 = new Student("Logan","Paul","logn@gmail.com");
		students.add(student1);
		Student student2 = new Student("Ralph","Loren","ralph@gmail.com");
		students.add(student2);
		Student student3 = new Student("Jan","Lam","jan@gmail.com");
		students.add(student3);

		System.out.println("Saving the student...");
		for(Student student : students) {
			studentDAO.save(student);
			System.out.println(student.getFirstName() + " student was saved. Generated ID: " + student.getId());
		}
	}

	private void createStudent(StudentDAO studentDAO) {

		System.out.println("Creating student...");
		Student student = new Student("John","Doe","john@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(student);

		System.out.println("Student was saved. Generated ID: " + student.getId());
	}
}
