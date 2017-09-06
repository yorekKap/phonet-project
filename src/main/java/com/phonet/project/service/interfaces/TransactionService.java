package com.phonet.project.service.interfaces;

import com.phonet.project.domain.Transaction;

import java.util.List;

/**
 * Created by yuri on 06.09.17.
 */
public interface TransactionService {
    List<Transaction> findAll();
    List<Transaction> findAllByAccountId(Long accountId);
    Transaction findOneById(Long id);
    Transaction save(Long accountId, Double sum);
    void delete(Long id);
}
