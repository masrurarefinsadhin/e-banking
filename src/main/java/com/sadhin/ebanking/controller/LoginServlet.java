package com.sadhin.ebanking.controller;

import com.sadhin.ebanking.service.LoginService;
import com.sadhin.ebanking.dto.UserDetail;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        LoginService loginService=new LoginService();
        UserDetail userDetail=loginService.getUserDetail(email, password);
        if(userDetail!=null){
            request.getSession().setAttribute("userDetail",userDetail);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("dashboard");
            requestDispatcher.forward(request,response);
        }
        else{
            response.sendRedirect("index");
        }

    }
}
