package com.phonet.project.dao.impl.jpa;

import com.phonet.project.dao.interfaces.TransactionDao;
import com.phonet.project.domain.Account;
import com.phonet.project.domain.Transaction;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by yuri on 06.09.17.
 */
@Repository
public class TransactionDaoJpaImpl extends AbstractJpaDao<Transaction, Long> implements TransactionDao {
    public TransactionDaoJpaImpl() {
        super(Transaction.class);
    }

    @Override
    @Transactional
    public List<Transaction> findAllByAccountId(Long accountId) {
        return entityManager.createQuery("FROM Transaction WHERE account.id=:accountId",
                Transaction.class)
                .setParameter("accountId", accountId)
                .getResultList();
    }

    @Override
    @Transactional
    public Transaction save(Long accountId, Double sum) {
       Account account = entityManager.getReference(Account.class, accountId);
       Transaction transaction = new Transaction();
       transaction.setSum(sum);
       transaction.setAccount(account);

       entityManager.persist(transaction);

       return transaction;
    }
}
