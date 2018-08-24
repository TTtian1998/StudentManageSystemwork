package com.TianZeXin.servlet;

import com.TianZeXin.controller.GradeController;
import com.TianZeXin.flection.Resourse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteGradeServlet")
public class DeleteGradeServlet extends HttpServlet {
    @Resourse(value = "controller.GradeController")
    private static GradeController controller;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ids=request.getParameter("ids");
        String gradeIds[]=ids.split(",");

        Integer[] idParams =new Integer[gradeIds.length];
        int i=0;
        for(String id:gradeIds){
            idParams[i++]=Integer.valueOf(id);
        }
        int result = controller.deleteGrade(idParams);
        response.getWriter().append("true");
    }
}
