package com.TianZeXin.servlet;

import com.TianZeXin.controller.InfoController;
import com.TianZeXin.entity.Info;
import com.TianZeXin.flection.Resourse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AlterInfoServlet")
public class AlterInfoServlet extends HttpServlet {
    @Resourse(value = "controller.InfoController")
    private static InfoController controller;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id= Integer.valueOf(request.getParameter("id"));
        Integer studentNumber1= Integer.valueOf(request.getParameter("studentNumber1"));
        String studentName1 =request.getParameter("studentName1");
        String studentSex1=request.getParameter("studentSex1");
        Integer studentAge1= Integer.parseInt(request.getParameter("studentAge1"));
        String studentMajor1=request.getParameter("studentMajor1");

        Info info=null;
        info=new Info(studentNumber1,studentName1,studentSex1,studentAge1,studentMajor1);
        info.setId(id);
        int result=controller.alterInfo(info,id);
        if (result > 0) {
            response.getWriter().append("true");
        }
        else{
            response.getWriter().append("false");
        }
    }
}
