package com.TianZeXin.controller;

import com.TianZeXin.entity.Info;
import com.TianZeXin.flection.Resourse;
import com.TianZeXin.service.InfoService;

import java.util.List;
import java.util.Map;

public class InfoController {
    @Resourse(value = "service.iml.InfoServiceIml")
    private static InfoService service;

    //新增一个学生信息
    public int addInfo(Info info){
        return service.addInfo(info);
    }

    //获取所有学生信息
    public List<Map<String,Object>> getInfos(Info info){
        return service.getInfos(info);
    }

    //根据主键更改信息
    public int alterInfo(Info info,Integer id){
        return service.alterInfo(info,id);
    }
    //根据条件查询
    public List<Info> getInfo(Info info){return  service.getInfo(info);}

    //根据主键删除信息
    public int deleteInfo(Integer[] ids){
        return service.deleteInfo(ids);
    }


}
