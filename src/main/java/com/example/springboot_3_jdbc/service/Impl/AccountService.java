package com.example.springboot_3_jdbc.service.Impl;

import com.example.springboot_3_jdbc.bean.Account;
import com.example.springboot_3_jdbc.dao.Impl.AccountDao;
import com.example.springboot_3_jdbc.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public int add(Account account) {
        return accountDao.add(account);
    }

    @Override
    public int update(Account account) {
        return accountDao.update(account);
    }

    @Override
    public int delete(int id) {
        return accountDao.delete(id);
    }

    @Override
    public Account findAccountById(int id) {
        return accountDao.findAccountById(id);
    }

    @Override
    public List<Account> findAccountList() {
        return accountDao.findAccountList();
    }
}
