package com.TianZeXin.service.iml;

import com.TianZeXin.dao.EntityDao;
import com.TianZeXin.entity.Grade;
import com.TianZeXin.flection.Resourse;
import com.TianZeXin.service.GradeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GradeServiceIml implements GradeService {
    @Resourse(value = "dao.EntityDao")
    private static EntityDao dao;

    @Override
    public int addGrade(Grade grade) {
        int result=dao.saveEntity(grade,Grade.class);
        if(result>0){
            return result;
        }
        return -1;
    }

    //删除
    @Override
    public int deleteGrade(Integer[] ids) {
        int result = -1;
        result = dao.deleteEntitys(ids, Grade.class);
        return result;
    }

    //修改
    @Override
    public int alterGrade(Grade grade, Integer id) {
        String condition = " id=" + id;

        return dao.updateEntityByCondition(grade, condition, Grade.class);
    }

    @Override
    public List<Map<String, Object>> getGrades(Grade grade) {
        List<Grade> grades = null;
        String condition = getCondition(grade);
        grades = dao.getEntitysByCondition(condition, Grade.class);

        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        if (grades == null) {
            return null;
        }

        for (Grade grade1 : grades) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", grade1.getId());
            map.put("number", grade1.getNumber());
            map.put("name", grade1.getName());
            map.put("math", grade1.getMath());
            map.put("chinese", grade1.getChinese());
            map.put("english", grade1.getEnglish());
            map.put("java", grade1.getJava());
            result.add(map);
        }
        return result;
    }

    private String getCondition(Grade grade) {
        String condition = "";
        if (grade.getId() != null) {
            condition += " and id=" + grade.getId();
        }
        if(grade.getNumber() !=null){
            condition +="and student_number'" + grade.getNumber()+"'";
        }
        if (grade.getName() != null && !grade.getName().isEmpty()) {
            condition += " and student_name='" + grade.getName() + "'";
        }

        if (grade.getMath() != null && !grade.getMath().isEmpty()) {
            condition += " and student_sex='" + grade.getMath() + "'";
        }
        if (grade.getChinese() != null && !grade.getChinese().isEmpty()) {
            condition += " and student_major='" + grade.getChinese() + "'";
        }
        if (grade.getEnglish() != null && !grade.getEnglish().isEmpty()) {
            condition += " and student_major='" + grade.getEnglish() + "'";
        }
        if (grade.getJava() != null && !grade.getJava().isEmpty()) {
            condition += " and student_major='" + grade.getJava() + "'";
        }

        return condition;
    }

    @Override
    public List<Grade> getInfo(Grade grade) {
        String condition = getCondition(grade);
        List<Grade> result = dao.getEntitysByCondition(condition, Grade.class);

        return result;
    }
}
