package com.moldavets.aopdemo;

import com.moldavets.aopdemo.dao.AccountDAO;
import com.moldavets.aopdemo.dao.MemberDAO;
import com.moldavets.aopdemo.entity.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MemberDAO memberDAO) {
		return runner -> {
			demoTheBeforeAdvice(accountDAO,memberDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MemberDAO memberDAO) {

		accountDAO.addAccount(true,new Account());

		memberDAO.addMember();
	}

}
