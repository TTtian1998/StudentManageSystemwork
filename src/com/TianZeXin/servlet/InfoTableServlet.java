package com.TianZeXin.servlet;

import com.TianZeXin.controller.InfoController;
import com.TianZeXin.entity.Info;
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

@WebServlet(name = "InfoTableServlet")
public class InfoTableServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Resourse(value = "controller.InfoController")
    private static InfoController controller;

    public InfoTableServlet(){

        super();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Map<String,Object>> infos=controller.getInfos(new Info());
        //转换为Json数组
        JSONArray jsonArray = JSONArray.fromObject(infos);
        System.out.println(jsonArray);

        response.setCharacterEncoding("UTF-8");
        response.getWriter().append(jsonArray.toString());
    }
}
