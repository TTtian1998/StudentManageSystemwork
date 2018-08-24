package com.TianZeXin.service;

import com.TianZeXin.entity.Grade;

import java.util.List;
import java.util.Map;

public interface GradeService {
    public int addGrade(Grade grade);

    public int deleteGrade(Integer[] ids);

    public int alterGrade(Grade grade,Integer id);

    List<Map<String, Object>> getGrades(Grade grade);

    public List<Grade> getInfo(Grade grade);
}
