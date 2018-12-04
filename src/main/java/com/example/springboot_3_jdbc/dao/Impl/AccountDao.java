package com.example.springboot_3_jdbc.dao.Impl;

import com.example.springboot_3_jdbc.bean.Account;
import com.example.springboot_3_jdbc.dao.IAccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDao implements IAccountDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Account account) {
        return jdbcTemplate.update("insert into account(name,money) values(?,?)"
                ,account.getName(),account.getMoney());
    }

    @Override
    public int update(Account account) {
        return jdbcTemplate.update("update account set name=? ,money=? where id=?"
                ,account.getName(),account.getMoney(),account.getID());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("delete from account where id=?",id);
    }

    @Override
    public Account findAccountById(int id) {
        List<Account> list =  jdbcTemplate.query("select * from account where id=?",new Object[]{id},new BeanPropertyRowMapper(Account.class));
        if(list != null && list.size() > 0){
            return list.get(0);
        }else {
            return null;
        }
    }

    @Override
    public List<Account> findAccountList() {
        List<Account> list =  jdbcTemplate.query("select * from account ",new Object[]{},new BeanPropertyRowMapper(Account.class));
        if(list != null && list.size() > 0){
            return list;
        }else {
            return null;
        }
    }
}
