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

/**
 * @author 田泽鑫
 * @date 2018/8/22
 */
@WebServlet(name = "SearchInfoServlet")
public class SearchInfoServlet extends HttpServlet {
    @Resourse(value = "controller.InfoController")
    private static InfoController controller;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        Info info=new Info();
        info.setName(name);
        System.out.println(name+" 测试1");
        List<Map<String, Object>> infos = controller.getInfos(info);
        System.out.println(name+"测试222");
        System.out.println(name+"测试2");
        if (infos == null) {
            response.getWriter().append("false");
        } else {
            response.setCharacterEncoding("utf-8");
            response.getWriter().append(JSONArray.fromObject(infos).toString());
        }
    }
}
