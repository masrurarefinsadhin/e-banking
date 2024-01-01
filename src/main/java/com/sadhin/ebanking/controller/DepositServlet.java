package com.sadhin.ebanking.controller;

import com.sadhin.ebanking.service.TransactionService;
import com.sadhin.ebanking.dto.UserDetail;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "DepositServlet", value = "/DepositServlet")
public class DepositServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BigDecimal depositAmount=new BigDecimal(request.getParameter("amount"));
        HttpSession session = request.getSession();
        UserDetail userDetail = (UserDetail) session.getAttribute("userDetail");
        TransactionService transactionService=new TransactionService();
        Boolean result = transactionService.deposit(userDetail.getUserId(),depositAmount);
        if(result){
            System.out.println("Deposit successful");
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("balance");
            requestDispatcher.forward(request,response);
        }
        else{
            System.out.println("Deposit unsuccessful");
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("deposit");
            requestDispatcher.forward(request,response);
        }

    }
}
