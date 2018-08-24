package com.TianZeXin.entity;

import java.io.Serializable;

public abstract class Entity implements Serializable {
    /**在反序列化时，确保类版本的兼容性*/
    private static final long serialVersionUID = 1L;

    /** 返回表名 */
    public abstract String getTableName();
}