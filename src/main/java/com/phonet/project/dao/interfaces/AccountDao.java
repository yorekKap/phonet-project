package com.phonet.project.dao.interfaces;

import com.phonet.project.domain.Account;

/**
 * Created by yuri on 06.09.17.
 */
public interface AccountDao extends GenericDao<Account, Long> {
    void addToSum(Long accountId, Double sum);
}
