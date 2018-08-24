package com.TianZeXin.servlet;

import com.TianZeXin.controller.GradeController;
import com.TianZeXin.entity.Grade;
import com.TianZeXin.flection.Resourse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddGradeServlet")
public class AddGradeServlet extends HttpServlet {
    @Resourse(value = "controller.GradeController")
    private static GradeController controller;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer studentNumber= Integer.valueOf(request.getParameter("studentNumber"));
        String studentName=request.getParameter("studentName");
        String Math=request.getParameter("Math");
        String Chinese=request.getParameter("Chinese");
        String English=request.getParameter("English");
        String Java=request.getParameter("Java");

        Grade grade=null;
        grade=new Grade(studentNumber,studentName,Math,Chinese,English,Java);

        int result =controller.addGrade(grade);
        if (result > 0){
            response.getWriter().append("true");
        }
        else{
            response.getWriter().append("false");
        }
    }
}
