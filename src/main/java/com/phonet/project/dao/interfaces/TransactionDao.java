package com.phonet.project.dao.interfaces;


import com.phonet.project.domain.Transaction;

import java.util.List;

/**
 * Created by yuri on 06.09.17.
 */
public interface TransactionDao extends GenericDao<Transaction, Long> {
    List<Transaction> findAllByAccountId(Long accountId);
    Transaction save(Long accountId, Double sum);
}
