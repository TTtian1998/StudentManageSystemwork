package com.TianZeXin.service;

import com.TianZeXin.entity.Info;

import java.util.List;
import java.util.Map;

public interface InfoService {
    public int addInfo(Info info);

    public int deleteInfo(Integer[] ids);

    public int alterInfo(Info info,Integer id);

    List<Map<String, Object>> getInfos(Info info);

    List<Info> getInfo(Info info);
}
