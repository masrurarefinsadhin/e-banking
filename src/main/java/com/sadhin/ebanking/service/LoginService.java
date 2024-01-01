package com.sadhin.ebanking.service;

import com.sadhin.ebanking.dao.JdbcConnectionImpl;
import com.sadhin.ebanking.dao.UserDaoImpl;
import com.sadhin.ebanking.dto.UserDetail;

import java.sql.Connection;

public class LoginService {
    public boolean authenticate(String email, String password) {
        return (password != null && !password.trim().equals("")) && (email != null && !email.trim().equals(""));
    }
    public UserDetail getUserDetail(String email, String password) {
        return new UserDaoImpl().getUserDetail(email, password);
    }

    public UserDetail register(String email, String password, String name, String mobile) {
        if ((password != null && !password.trim().equals("")) &&
                (email != null && !email.trim().equals("")) &&
                (name != null && !name.trim().equals("")) &&
                (mobile != null && !mobile.trim().equals(""))) {
            return new UserDaoImpl().createUser(email, password, name, mobile);
        }
        return null;
    }

}
