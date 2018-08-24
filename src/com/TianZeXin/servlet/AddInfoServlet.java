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

@WebServlet(name = "AddInfoServlet")
public class AddInfoServlet extends HttpServlet {
    @Resourse(value = "controller.InfoController")
    private static InfoController controller;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer studentNumber= Integer.valueOf(request.getParameter("studentNumber"));
        String studentName =request.getParameter("studentName");
        String studentSex=request.getParameter("studentSex");
        Integer studentAge= Integer.parseInt(request.getParameter("studentAge"));
        String studentMajor=request.getParameter("studentMajor");

        Info info=null;
            info=new Info(studentNumber,studentName,studentSex,studentAge,studentMajor);

            int result=controller.addInfo(info);
        if (result > 0) {
            response.getWriter().append("true");
        }
        else{
            response.getWriter().append("false");
        }
    }
}
