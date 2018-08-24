package com.TianZeXin.servlet;

import com.TianZeXin.controller.InfoController;
import com.TianZeXin.flection.Resourse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteInfoServlet")
public class DeleteInfoServlet extends HttpServlet {
    @Resourse(value = "controller.InfoController")
    private static InfoController controller;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ids=request.getParameter("ids");
        String InfoIds[]=ids.split(",");

        Integer[] idParams =new Integer[InfoIds.length];
        int i=0;
        for(String id:InfoIds){
            idParams[i++]=Integer.valueOf(id);
        }
        int result = controller.deleteInfo(idParams);
        response.getWriter().append("true");
    }
}
