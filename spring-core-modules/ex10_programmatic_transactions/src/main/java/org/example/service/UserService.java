package org.example.service;

import org.example.dao.UserDao;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PlatformTransactionManager transactionManager;

    public void createUser(String username) {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            userDao.addUser(username);
            if ("error".equals(username)) {
                throw new RuntimeException("Simulated error");
            }
            transactionManager.commit(status);
        } catch (Exception e) {
            transactionManager.rollback(status);
            throw e;
        }
    }

    public void transferMoney(Long fromAccountId, Long toAccountId, double amount) {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            User fromAccount = userDao.findById(fromAccountId).orElseThrow(() -> new RuntimeException("From account not found"));
            User toAccount = userDao.findById(toAccountId).orElseThrow(() -> new RuntimeException("To account not found"));

            fromAccount.setBalance(fromAccount.getBalance() - amount);
            userDao.save(fromAccount);

            toAccount.setBalance(toAccount.getBalance() + amount);
            userDao.save(toAccount);

            transactionManager.commit(status);
        } catch (Exception e) {
            transactionManager.rollback(status);
            throw e;
        }
    }
}