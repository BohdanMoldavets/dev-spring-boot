package com.moldavets.aopdemo.dao;

import com.moldavets.aopdemo.entity.Account;

public interface AccountDAO {

    void addAccount(boolean vipFlag,Account account);

}
