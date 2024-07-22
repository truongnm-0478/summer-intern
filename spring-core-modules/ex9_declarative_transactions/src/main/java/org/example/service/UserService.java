package org.example.service;

import org.example.dao.UserDao;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void createUser(String username) {
        userDao.addUser(username);
        if ("error".equals(username)) {
            throw new RuntimeException("Simulated error");
        }
    }

    @Transactional
    public void transferMoney(Long fromAccountId, Long toAccountId, double amount) {
        User fromAccount = userDao.findById(fromAccountId).orElseThrow(() -> new RuntimeException("From account not found"));
        User toAccount = userDao.findById(toAccountId).orElseThrow(() -> new RuntimeException("To account not found"));

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        userDao.save(fromAccount);

        toAccount.setBalance(toAccount.getBalance() + amount);
        userDao.save(toAccount);
    }
}