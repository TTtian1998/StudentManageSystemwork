package com.TianZeXin.service.iml;

import com.TianZeXin.dao.EntityDao;
import com.TianZeXin.entity.Info;
import com.TianZeXin.flection.Resourse;
import com.TianZeXin.service.InfoService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InfoServiceIml implements InfoService {
    @Resourse(value = "dao.EntityDao")
    private static EntityDao dao;

    //增加
    @Override
    public int addInfo(Info info) {
        int result=dao.saveEntity(info,Info.class);
        if(result>0){
            return result;
        }
        return -1;
    }

    //删除
    @Override
    public int deleteInfo(Integer[] ids) {
        int result = -1;
        result = dao.deleteEntitys(ids, Info.class);
        return result;
    }

    //修改
    @Override
    public int alterInfo(Info info, Integer id) {
        String condition = " id=" + id;

        return dao.updateEntityByCondition(info, condition, Info.class);
    }

    @Override
    public List<Map<String, Object>> getInfos(Info info) {
        List<Info> infos = null;
        String condition = getCondition(info);
        infos = dao.getEntitysByCondition(condition, Info.class);

        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        if (infos == null) {
            return null;
        }

        for (Info info1 : infos) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", info1.getId());
            map.put("number", info1.getNumber());
            map.put("name", info1.getName());
            map.put("sex", info1.getSex());
            map.put("age", info1.getAge());
            map.put("major", info1.getMajor());
            result.add(map);
        }
        return result;
    }

    private String getCondition(Info info) {
        String condition = "";
        if (info.getId() != null) {
            condition += " and id=" + info.getId();
        }
        if(info.getNumber() !=null){
            condition +="and student_number'" + info.getNumber()+"'";
        }
        if (info.getName() != null && !info.getName().isEmpty()) {
            condition += " and student_name='" + info.getName() + "'";
        }
        if (info.getSex() != null && !info.getSex().isEmpty()) {
            condition += " and student_sex='" + info.getSex() + "'";
        }
        if (info.getAge() != null) {
            condition += " and student_age=" + info.getAge();
        }
        if (info.getMajor() != null && !info.getMajor().isEmpty()) {
            condition += " and student_major='" + info.getMajor() + "'";
        }

        return condition;
    }
    @Override
    public List<Info> getInfo(Info info) {
        String condition = getCondition(info);
        List<Info> result = dao.getEntitysByCondition(condition, Info.class);

        return result;
    }
}
