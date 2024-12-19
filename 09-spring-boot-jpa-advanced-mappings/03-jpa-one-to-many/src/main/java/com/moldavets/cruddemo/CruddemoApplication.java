package com.moldavets.cruddemo;

import com.moldavets.cruddemo.dao.AppDAO;
import com.moldavets.cruddemo.entity.Course;
import com.moldavets.cruddemo.entity.Instructor;
import com.moldavets.cruddemo.entity.InstructorDetail;
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
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetailById(appDAO);
			//deleteInstructorDetailById(appDAO);
			//createInstructorWithCourses(appDAO);
			//findInstructorWithCourses(appDAO);
			//findCoursesForInstructor(appDAO);
			//findInstructorWithCoursesJoinFetch(appDAO);
			//updateInstructor(appDAO);
			//updateCourse(appDAO);
			deleteCourse(appDAO);
		};
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

}