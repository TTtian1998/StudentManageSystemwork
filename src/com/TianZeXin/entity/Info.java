package com.TianZeXin.entity;

import com.TianZeXin.flection.Column;

@SuppressWarnings("serial")
public class Info extends Entity {
    @Column(value = "id",type = "Integer")
    private Integer id;
    @Column(value = "number",type = "Integer")
    private Integer number;
    @Column(value = "name",type="String")
    private String name;
    @Column(value = "sex",type="String")
    private String sex;
    @Column(value = "age",type="Integer")
    private Integer age;
    @Column(value = "major",type="String")
    private String major;

    public Info(){

    }
    public Info(Integer number,String name,String sex,Integer age,String major){
        this.number=number;
        this.name=name;
        this.sex=sex;
        this.age=age;
        this.major=major;
    }
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    @Override
    public String getTableName(){
        return "info";
    }
}
