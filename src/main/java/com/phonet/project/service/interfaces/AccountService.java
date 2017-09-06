package com.phonet.project.service.interfaces;

import com.phonet.project.domain.Account;

import java.util.List;

/**
 * Created by yuri on 06.09.17.
 */
public interface AccountService {
    List<Account> findAll();
    Account findById(Long id);
    Account save(Account account);
    Account update(Account account);
    void addToSum(Long accountId, Double sum);
    void delete(Long id);
}
