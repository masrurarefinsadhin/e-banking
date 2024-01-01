package com.sadhin.ebanking.dao;

import com.sadhin.ebanking.dto.UserDetail;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl {

    public UserDetail createUser(String email, String password, String name, String phone) {
        Connection connection = new JdbcConnectionImpl().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into user(email,password,name,phone) values(?,?,?,?)");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, phone);
            preparedStatement.executeUpdate();

            UserDetail userDetail = getUserDetail(email, password);
            if (userDetail != null) {
                System.out.println("-------------------------------------");
                System.out.println(userDetail.getEmail());
                System.out.println(userDetail.getUserId());
                preparedStatement = connection.prepareStatement("insert into balance(userId, balance, currency) values(?, ?, ?)");
                preparedStatement.setInt(1, userDetail.getUserId());
                preparedStatement.setBigDecimal(2, new BigDecimal(0));
                preparedStatement.setString(3, "BDT");
                preparedStatement.executeUpdate();
            }

            return userDetail;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public UserDetail getUserDetail(String email, String password) {
        Connection connection = new JdbcConnectionImpl().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user where email=? and password=?");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                UserDetail userDetail = new UserDetail();
                userDetail.setUserId(rs.getInt("userId"));
                userDetail.setEmail(rs.getString("email"));
                userDetail.setPassword(rs.getString("password"));
                userDetail.setName(rs.getString("name"));
                userDetail.setPhone(rs.getString("phone"));
                return userDetail;
            }
            return null;

        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



}
