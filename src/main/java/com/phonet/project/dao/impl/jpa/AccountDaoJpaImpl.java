package com.phonet.project.dao.impl.jpa;

import com.phonet.project.dao.interfaces.AccountDao;
import com.phonet.project.domain.Account;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by yuri on 06.09.17.
 */
@Repository
public class AccountDaoJpaImpl extends AbstractJpaDao<Account, Long> implements AccountDao {
    public AccountDaoJpaImpl() {
        super(Account.class);
    }

    @Transactional
    public void addToSum(Long accountId, Double sum) {
        Account account = entityManager.find(Account.class, accountId);

        if (account.getSum() < (sum * -1)) {
            throw new IllegalArgumentException("Sum of account can't be negative");
        }

        account.setSum(account.getSum() + sum);
        entityManager.merge(account);
    }
}
