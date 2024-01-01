package com.sadhin.ebanking.service;

import com.sadhin.ebanking.dao.BalanceDaoImpl;
import com.sadhin.ebanking.dto.BalanceDetail;

import java.math.BigDecimal;

public class TransactionService {
    public BalanceDetail getBalanceDetail(int userId) {
        BalanceDetail balanceDetail= new BalanceDaoImpl().getBalanceDetail(userId);
        if (balanceDetail!=null) return balanceDetail;
        else return new BalanceDetail();
    }
    public boolean deposit(int userId, BigDecimal depositAmount) {
        BalanceDaoImpl balanceDao = new BalanceDaoImpl();
        return balanceDao.deposit(userId, depositAmount);
    }

    public boolean withdraw(int userId, BigDecimal withdrawAmount) {
        BalanceDaoImpl balanceDao = new BalanceDaoImpl();
        return balanceDao.withdraw(userId, withdrawAmount);
    }
}
