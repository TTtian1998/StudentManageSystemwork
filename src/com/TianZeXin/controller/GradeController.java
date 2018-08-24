package com.TianZeXin.controller;

import com.TianZeXin.entity.Grade;
import com.TianZeXin.flection.Resourse;
import com.TianZeXin.service.GradeService;

import java.util.List;
import java.util.Map;

public class GradeController {
    @Resourse(value = "service.iml.GradeServiceIml")
    private static GradeService service;

    //新增一个学生成绩
    public int addGrade(Grade grade){
        return service.addGrade(grade);
    }

    //获取所有学生成绩
    public List<Map<String,Object>> getGrades(Grade grade){
        return service.getGrades(grade);
    }

    //根据主键更改成绩
    public int alterGrade(Grade grade,Integer id){
        return service.alterGrade(grade,id);
    }

    //根据主键删除信息
    public int deleteGrade(Integer[] ids){
        return service.deleteGrade(ids);
    }
}
