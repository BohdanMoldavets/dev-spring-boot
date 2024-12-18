package com.moldavets.cruddemo;

import com.moldavets.cruddemo.dao.AppDAO;
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
			deleteInstructorDetailById(appDAO);
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
		int id = 3;

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

}