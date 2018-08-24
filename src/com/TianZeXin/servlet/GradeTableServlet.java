package com.TianZeXin.servlet;

import com.TianZeXin.controller.GradeController;
import com.TianZeXin.entity.Grade;
import com.TianZeXin.flection.Resourse;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "GradeTableServlet")
public class GradeTableServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Resourse(value = "controller.GradeController")
    private static GradeController controller;
    public GradeTableServlet(){

        super();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Map<String,Object>> grades=controller.getGrades(new Grade());
        //转换为Json数组
        JSONArray jsonArray = JSONArray.fromObject(grades);
        System.out.println(jsonArray);

        response.setCharacterEncoding("UTF-8");
        response.getWriter().append(jsonArray.toString());
    }
}
