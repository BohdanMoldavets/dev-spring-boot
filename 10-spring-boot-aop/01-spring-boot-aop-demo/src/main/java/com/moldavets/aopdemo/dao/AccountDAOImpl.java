package com.moldavets.aopdemo.dao;

import com.moldavets.aopdemo.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(boolean vipFlag,Account account) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }
}
