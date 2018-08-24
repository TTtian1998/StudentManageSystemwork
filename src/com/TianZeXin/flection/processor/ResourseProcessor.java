package com.TianZeXin.flection.processor;

import com.TianZeXin.controller.GradeController;
import com.TianZeXin.controller.InfoController;
import com.TianZeXin.controller.UserController;
import com.TianZeXin.flection.Resourse;
import com.TianZeXin.service.iml.GradeServiceIml;
import com.TianZeXin.service.iml.InfoServiceIml;
import com.TianZeXin.service.iml.UserServiceIml;
import com.TianZeXin.servlet.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 注解处理器
 *
 * @author tzx
 * @date 2018/08/20
 */
public class ResourseProcessor {

    public ResourseProcessor() {
        System.out.println("注解处理器");
        init(UserServiceIml.class);
        init(InfoServiceIml.class);
        init(GradeServiceIml.class);

        init(UserController.class);
        init(InfoController.class);
        init(GradeController.class);

        init(LoginServlet.class);
        init(RegistServlet.class);
        init(TableServlet.class);
        init(InfoTableServlet.class);
        init(GradeTableServlet.class);

        init(AddInfoServlet.class);
        init(AddGradeServlet.class);
        init(DeleteInfoServlet.class);
        init(DeleteGradeServlet.class);
        init(AlterInfoServlet.class);
        init(AlterGradeServlet.class);
    }


    /**
     * 注入对象
     */
    private void init(Class<?> clazz) {
        //获取描述对象
        Field[] fields = clazz.getDeclaredFields();

        if (fields == null) {
            System.out.println(clazz.getName() + "中无属性");
            return;
        }

        for (Field field : fields) {
            //获取每个字段上的注解
            Annotation[] annotations = field.getAnnotations();
            System.out.println(field.getName() + "有" + annotations.length + "个注解");

            for (Annotation annotation : annotations) {
                //判断是否是注解类型
                if (annotation.annotationType() == Resourse.class) {
                    System.out.println("该注解是Resourse类型");
                    //获取需要使用的Name
                    String Name = ((Resourse) annotation).value();
                    System.out.println(Name + "------------------------");
                    // 产生一个指定的ServiceIml的对象
                    try {
                        Class<?> c = Class.forName("com.TianZeXin." + Name);
                        Object ob = c.newInstance();
                        // 私有属性能被修改base
                        field.setAccessible(true);

                        // 通过set方法将新建的实例对象赋值给private EntityDao dao
                        field.set(null, ob);
                        System.out.println("注入" + c.getName() + "成功");
                    } catch (ClassNotFoundException e) {
                        System.out.println("找不到" + "com.TianZeXin." + Name);
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}

