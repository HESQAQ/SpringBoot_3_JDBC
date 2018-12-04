package com.example.springboot_3_jdbc.web;

import com.example.springboot_3_jdbc.bean.Account;
import com.example.springboot_3_jdbc.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    IAccountService accountService;

    @RequestMapping(value="/list",method = RequestMethod.GET)
    public List<Account> getAccounts() {
        return accountService.findAccountList();
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Account getAccountByID(@PathVariable("id") int id ){
        return accountService.findAccountById(id);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id,@RequestParam(value = "name",required = true)String name,
                                @RequestParam(value = "money" ,required = true)double money){
        Account account = new Account();
        account.setID(id);
        account.setName(name);
        account.setMoney(money);

        int flag = accountService.update(account);
        if(flag == 1) {
            return account.toString();
        }else {
            return "fail~";
        }
    }

    @RequestMapping(value="" , method = RequestMethod.POST)
    public String postAccount(@RequestParam(value="name")String name,@RequestParam(value="money")double money){
        Account account = new Account();
        account.setName(name);
        account.setMoney(money);
        int flag = accountService.add(account);

        if(flag == 1) {
            return account.toString();
        }else {
            return "fail~";
        }

    }
}
