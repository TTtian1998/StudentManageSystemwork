package com.TianZeXin.entity;

import com.TianZeXin.flection.Column;

/** 序列化时为了保持版本的兼容性，
 * 即在版本升级时反序列化仍保持对象的唯一性。*/
@SuppressWarnings("serial")
public class User extends Entity{
    @Column(value = "id",type = "Integet")
    private Integer id;
    @Column(value = "username",type = "String")
    private String username;
    @Column(value = "password",type = "String")
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String getTableName(){
        return "user";
    }
}
