package com.moldavets.aopdemo.dao;

import com.moldavets.aopdemo.entity.Account;

public interface AccountDAO {

    void addAccount(boolean vipFlag,Account account);
    boolean doWork();

    String getName();

    void setName(String name);

    String getServiceCode();

    void setServiceCode(String serviceCode);

}
