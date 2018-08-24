package com.TianZeXin.entity;

import com.TianZeXin.flection.Column;

@SuppressWarnings("serial")
public class Grade extends Entity {
    @Column(value = "id",type = "Integer")
    private Integer id;
    @Column(value = "number",type = "Integer")
    private Integer number;
    @Column(value = "name",type = "String")
    private String name;
    @Column(value = "math",type = "String")
    private String math;
    @Column(value = "chinese",type = "String")
    private String chinese;
    @Column(value = "english",type = "String")
    private String english;
    @Column(value = "java",type = "String")
    private String java;

    public Grade(Integer number,String name, String math, String chinese, String english, String java) {
        this.number=number;
       this.name=name;
       this.math=math;
       this.chinese=chinese;
       this.english=english;
       this.java=java;
    }

    public Grade() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMath() {
        return math;
    }

    public void setMath(String math) {
        this.math = math;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getJava() {
        return java;
    }

    public void setJava(String java) {
        this.java = java;
    }

    @Override
    public String getTableName(){
        return "grade";
    }
}
