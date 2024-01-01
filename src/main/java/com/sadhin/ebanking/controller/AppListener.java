package com.sadhin.ebanking.controller;

import com.sadhin.ebanking.dao.JdbcConnectionImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AppListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public AppListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        try {
            Connection connection = new JdbcConnectionImpl().getConnection();
            System.out.println("Connection Established");
            PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS `e-banking`.`user` (\n" +
                    "  `userId` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `email` VARCHAR(45) NOT NULL,\n" +
                    "  `password` VARCHAR(45) NOT NULL,\n" +
                    "  `name` VARCHAR(45) NOT NULL,\n" +
                    "  `phone` VARCHAR(45) NOT NULL,\n" +
                    "  PRIMARY KEY (`userId`),\n" +
                    "  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);");
            preparedStatement.executeUpdate();
            System.out.println("User Table Created");

            preparedStatement = connection.prepareStatement("CREATE TABLE balance (" +
                    "balanceId INT AUTO_INCREMENT PRIMARY KEY," +
                    "userId INT UNIQUE," +
                    "balance DECIMAL ," +
                    "currency VARCHAR(3)," +
                    "FOREIGN KEY (userId) REFERENCES user(userId)" +
                    ")");
            preparedStatement.executeUpdate();
            System.out.println("BalanceDetail Table Created");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }
}
