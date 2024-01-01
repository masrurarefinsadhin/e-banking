package com.sadhin.ebanking.controller;

import com.sadhin.ebanking.dto.UserDetail;
import com.sadhin.ebanking.service.LoginService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet", value = "/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String name=request.getParameter("name");
        String mobile=request.getParameter("mobileNumber");
        LoginService loginService=new LoginService();
        UserDetail userDetail=loginService.register(email,password,name,mobile);
        if(userDetail!=null){
            System.out.println("Registration successful");
            HttpSession session=request.getSession();
            session.setAttribute("userDetail",userDetail);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("dashboard");
            requestDispatcher.forward(request,response);
        }
        else{
            response.sendRedirect("registration");
        }


    }
}
