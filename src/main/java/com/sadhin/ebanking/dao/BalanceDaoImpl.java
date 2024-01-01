package com.sadhin.ebanking.dao;

import com.sadhin.ebanking.dto.BalanceDetail;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BalanceDaoImpl {

    public boolean withdraw(int userId, BigDecimal withdrawAmount) {
        try {
            Connection connection = new JdbcConnectionImpl().getConnection();
            BalanceDetail balanceDetail = getBalanceDetail(userId);
            if(balanceDetail==null) return false;

            BigDecimal withdrawLimit = balanceDetail.getBalance().subtract(new BigDecimal("100.00"));
            if (withdrawLimit.compareTo(withdrawAmount)>=0){
                BigDecimal balance = balanceDetail.getBalance();
                balance = balance.subtract(withdrawAmount);
                PreparedStatement preparedStatement = connection.prepareStatement("update balance set balance=? where userId=?");
                preparedStatement.setBigDecimal(1, balance);
                preparedStatement.setInt(2, userId);
                preparedStatement.executeUpdate();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deposit(int userId, BigDecimal depositAmount) {
        try {
            Connection connection = new JdbcConnectionImpl().getConnection();
            BalanceDetail balanceDetail = getBalanceDetail(userId);
            if (balanceDetail!=null){
                BigDecimal balance = balanceDetail.getBalance();
                balance = balance.add(depositAmount);
                PreparedStatement preparedStatement = connection.prepareStatement("update balance set balance=? where userId=?");
                preparedStatement.setBigDecimal(1, balance);
                preparedStatement.setInt(2, userId);
                preparedStatement.executeUpdate();
            }
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public BalanceDetail getBalanceDetail(int userId) {
        try {
            Connection connection = new JdbcConnectionImpl().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from balance where userId=?");
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                BalanceDetail balanceDetail = new BalanceDetail();
                balanceDetail.setBalanceId(rs.getInt("balanceId"));
                balanceDetail.setUserId(rs.getInt("userId"));
                balanceDetail.setBalance(rs.getBigDecimal("balance"));
                balanceDetail.setCurrency(rs.getString("currency"));
                return balanceDetail;
            }
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
