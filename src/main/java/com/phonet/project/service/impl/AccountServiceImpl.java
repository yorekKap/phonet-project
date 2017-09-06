package com.phonet.project.service.impl;

import com.phonet.project.dao.interfaces.AccountDao;
import com.phonet.project.domain.Account;
import com.phonet.project.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yuri on 06.09.17.
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Account findById(Long id) {
        return accountDao.findOne(id);
    }

    @Override
    public Account save(Account account) {
        accountDao.save(account);
        return account;
    }

    @Override
    public Account update(Account account) {
        accountDao.update(account);
        return account;
    }

    @Override
    public void addToSum(Long accountId, Double sum) {
        accountDao.addToSum(accountId, sum);
    }

    @Override
    public void delete(Long id) {
        accountDao.deleteById(id);
    }
}
