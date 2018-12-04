package com.example.springboot_3_jdbc.service;

import com.example.springboot_3_jdbc.bean.Account;

import java.util.List;

public interface IAccountService {
    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();
}
