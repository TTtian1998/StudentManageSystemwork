package com.TianZeXin.servlet;

import com.TianZeXin.controller.UserController;
import com.TianZeXin.flection.Resourse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistServlet")
public class RegistServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Resourse(value = "controller.UserController")
    private static UserController controller;

    public RegistServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        boolean result =controller.regist(username,password);
        if(result){
            //注册成功
            controller.test();
            response.getWriter().append(username);
            System.out.println("用户名："+username);
            response.getWriter().append(password);
            System.out.println("密码："+password);
        }
        else{
            response.getWriter().append(""+result);
        }
    }
}
