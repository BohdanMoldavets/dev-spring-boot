package com.moldavets.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MemberDAOImpl implements MemberDAO {

    @Override
    public boolean addMember() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN MEMEMBER");
        return true;
    }

}
