package com.moldavets.aopdemo;

import com.moldavets.aopdemo.dao.AccountDAO;
import com.moldavets.aopdemo.dao.MemberDAO;
import com.moldavets.aopdemo.entity.Account;
import com.moldavets.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO,
											   MemberDAO memberDAO, TrafficFortuneService trafficFortuneService) {
		return runner -> {
			//demoTheBeforeAdvice(accountDAO,memberDAO);
			//demoTheAfterReturningAdvice(accountDAO);
			demoTheAroundAdvice(trafficFortuneService);
		};
	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {

		System.out.println("--->demoTheAroundAdvice");
		System.out.println("Calling getFortune()");

		String data = trafficFortuneService.getFortune();

		System.out.println("Fortune: " + data);

		System.out.println("FINISH");

	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {

		List<Account> accounts = accountDAO.findAccounts();

		System.out.println("\n\nMain program: demoTheAfterReturningAdvice()");
		System.out.println("---------");

		System.out.println(accounts);



	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MemberDAO memberDAO) {

		accountDAO.addAccount(true,new Account("John","gmail.com"));

		memberDAO.addMember();

		accountDAO.setName("John");
		accountDAO.setServiceCode("Golda");

		accountDAO.getName();
		accountDAO.getServiceCode();

	}

}
