package com.phonet.project.service.impl;

import com.phonet.project.dao.interfaces.TransactionDao;
import com.phonet.project.domain.Transaction;
import com.phonet.project.service.interfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yuri on 06.09.17.
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionDao transactionDao;

    @Override
    public List<Transaction> findAll() {
        return transactionDao.findAll();
    }

    @Override
    public List<Transaction> findAllByAccountId(Long accountId) {
        return transactionDao.findAllByAccountId(accountId);
    }

    @Override
    public Transaction findOneById(Long id) {
        return transactionDao.findOne(id);
    }

    @Override
    public Transaction save(Long accountId, Double sum) {
        return transactionDao.save(accountId, sum);
    }

    @Override
    public void delete(Long id) {
        transactionDao.deleteById(id);
    }
}
