package com.moldavets.cruddemo;

import com.moldavets.cruddemo.dao.AppDAO;
import com.moldavets.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
//			createCourseAndReviews(appDAO);
//			retrieveCourseAndReviews(appDAO);
//			createCourseAndStudents(appDAO);
//			retrieveCourseAndStudents(appDAO);
//			findStudentAndCourses(appDAO);
//			addMoreCoursesForStudent(appDAO);
//			deleteCourse(appDAO);
			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		appDAO.deleteStudentById(1);
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {

		Course course1 = new Course("More Course for Student");
		Course course2 = new Course("Some private info");

		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(3);
		tempStudent.addCourse(course1);
		tempStudent.addCourse(course2);

		System.out.println(tempStudent);
		System.out.println(tempStudent.getCourses());

		appDAO.update(tempStudent);

	}

	private void findStudentAndCourses(AppDAO appDAO) {

	Student tempStudent = appDAO.findStudentAndCoursesByStudentId(3);

	System.out.println(tempStudent);
	System.out.println(tempStudent.getCourses());

	}

	private void retrieveCourseAndStudents(AppDAO appDAO) {

		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(1);

		System.out.println(tempCourse);
		System.out.println(tempCourse.getStudents());

	}

	private void createCourseAndStudents(AppDAO appDAO) {
		Course course = new Course("How to do something");

		Student student1 = new Student("John", "Doe","doe@gmail.com");
		Student student2 = new Student("Margo", "Trosa","matrosa@gmail.com");
		Student student3 = new Student("Eva", "Elfie","eva@gmail.com");

		course.addStudent(student1);
		course.addStudent(student2);
		course.addStudent(student3);

		System.out.println(course);
		System.out.println(course.getStudents());

		appDAO.save(course);

	}

	private static void createInstructor(AppDAO appDAO) {
		Instructor tempInstructor =
				new Instructor(
						"John",
						"Smith",
						"john.smith@gmail.com"
				);

		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
				"http://www.youtube.com/",
				"blogger"
		);

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving the instructor: " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done");
	}

	private static void findInstructor(AppDAO appDAO) {
		int id = 3;
		Instructor tempInstructor = appDAO.findInstructorById(id);

		if(tempInstructor != null) {
			System.out.println("Instructor found: " + tempInstructor);
			System.out.println("Instructor detail only: " + tempInstructor.getInstructorDetail());
		} else {
			System.out.printf("Instructor with id %s not found", id);
		}
	}

	private static void deleteInstructor(AppDAO appDAO) {
		int id = 1;

		System.out.println("Deleting the instructor by id:" + id);
		appDAO.deleteInstructorById(id);
		System.out.println("Instructor deleted");
	}

	private static void findInstructorDetailById(AppDAO appDAO) {
		int id = 3;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(id);
		System.out.println("Instructor detail only: " + tempInstructorDetail.getInstructor());
	}

	private static void deleteInstructorDetailById(AppDAO appDAO) {
		int id = 3;
		System.out.println("Deleting the instructor detail by id: " + id);
		appDAO.deleteInstructorDetailById(id);
		System.out.println("Instructor detail deleted");
	}

	private static void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor =
				new Instructor(
						"Susan",
						"Doe",
						"susan@gmail.com"
				);

		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.youtube.com/susan",
						"Video Games"
				);


		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course tempCourse1 = new Course("Dota2");
		Course tempCourse2 = new Course("CS");
		Course tempCourse3 = new Course("Minecraft");

		tempInstructor.addCourse(tempCourse1);
		tempInstructor.addCourse(tempCourse2);
		tempInstructor.addCourse(tempCourse3);

		System.out.println("Saving the instructor: " + tempInstructor);
		System.out.println("The courses:" + tempInstructor.getCourses());
		appDAO.save(tempInstructor);
	}

	private static void findInstructorWithCourses(AppDAO appDAO) {

		int id = 1;
		System.out.println("Finding the instructor by id:" + id);

		Instructor tempInstructor = appDAO.findInstructorById(id);
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("Associated courses:" + tempInstructor.getCourses());
		System.out.println("Done");


	}

	private static void findCoursesForInstructor(AppDAO appDAO) {

		int id = 1;
		System.out.println("Finding the instructor by id:" + id);

		Instructor tempInstructor = appDAO.findInstructorById(id);
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("Associated courses: " + appDAO.findCoursesByInstructorId(id));
		System.out.println("Done");
	}

	private static void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id = 1;

		System.out.println("Finding the instructor by id:" + id);

		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(id);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("Associated courses:" + tempInstructor.getCourses());
	}

	private static void updateInstructor(AppDAO appDAO) {
		int id = 1;

		System.out.println("Finding the instructor by id:" + id);
		Instructor tempInstructor = appDAO.findInstructorById(id);
		System.out.println("tempInstructor: " + tempInstructor);
		tempInstructor.setLastName("TEST");

		System.out.println("Updating the instructor: " + tempInstructor);
		appDAO.update(tempInstructor);
		System.out.println("Done");
	}

	private static void updateCourse(AppDAO appDAO) {
		int id = 3;

		System.out.println("Finding the course by id:" + id);
		Course tempCourse = appDAO.findCourseById(id);
		System.out.println("tempCourse: " + tempCourse);

		System.out.println("Updating the course: " + tempCourse);
		tempCourse.setTitle("TEST");
		appDAO.update(tempCourse);

		System.out.println("Done");
	}

	private static void deleteCourse(AppDAO appDAO) {
		int id = 3;

		System.out.println("Deleting the course by id:" + id);
		appDAO.deleteCourseById(id);
		System.out.println("Done");

	}

	private static void createCourseAndReviews(AppDAO appDAO) {
		Course tempCourse1 = new Course("Java course 1");
		tempCourse1.addReview(new Review("Great course!"));
		tempCourse1.addReview(new Review("Very great course!"));
		tempCourse1.addReview(new Review("Awesome course!"));

		System.out.println("Saving the course");
		System.out.println(tempCourse1);
		System.out.println(tempCourse1.getReviews());
		appDAO.save(tempCourse1);
	}

	private static void retrieveCourseAndReviews(AppDAO appDAO) {
		int id = 1;

		Course tempCourse = appDAO.findCourseAndReviewsById(id);

		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews().toString());

	}

}