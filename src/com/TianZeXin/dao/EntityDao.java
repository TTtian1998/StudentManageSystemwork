package com.TianZeXin.dao;

import com.TianZeXin.DBconnect.DBconnect;
import com.TianZeXin.entity.Entity;
import com.TianZeXin.flection.Column;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntityDao {
    //获取数据库的连接对象
    private Connection connection= DBconnect.getConnection();
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public <T extends Entity> List<T> getEntitysByCondition(String condition, Class<T> t) {
        List<T> resultList = new ArrayList<T>();
        Field[] fields = t.getDeclaredFields();

        try {
            Constructor<?> constructor = t.getConstructor(); // 通过Constructor实例化对象
            Object entity = constructor.newInstance();
            Method method = t.getMethod("getTableName");
            String tableName = (String) method.invoke(entity);
            String sql = "select * from " + tableName + " where 1=1 ";
            if (condition != null && !condition.isEmpty()) {
                sql += condition;
            }
           preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                T temp = t.newInstance();
                for (Field field : fields) {
                    Column annotation = field.getAnnotation(Column.class);
                    if (annotation != null) {
                        String sqlName = annotation.value();
                        String type = annotation.type();
                        String methodName = "set" + field.getName().toUpperCase().charAt(0)
                                + field.getName().substring(1);
                        if (type.equals("Integer")) {
                            temp.getClass().getMethod(methodName, Integer.class).invoke(temp, resultSet.getInt(sqlName));
                        }
                        if (type.equals("String")) {
                            temp.getClass().getMethod(methodName, String.class).invoke(temp, resultSet.getString(sqlName));
                        }
                        if (type.equals("Double")) {
                            temp.getClass().getMethod(methodName, Double.class).invoke(temp, resultSet.getDouble(sqlName));
                        }
//                        if (type.equals("Date")) {
//                            temp.getClass().getMethod(methodName, Date.class).invoke(temp, new Date(rs.getDate(sqlName).getTime()));
//                        }
                    }

                }

                resultList.add(temp);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeResource();
        return resultList;
    }

    //通过条件查询
    public <T extends Entity> T getEntityByCondition(String condition, Class<T> clazz) {
        List<T> list = getEntitysByCondition(condition, clazz);

        if (list != null && list.size() > 0) {
            return list.get(0);
        }

        return null;
    }

    //新增Entity
    public <T extends Entity>int saveEntity(Object object,Class<T> clazz){
        @SuppressWarnings("unchecked")
        T entity=(T)object;
        Class<?> t=entity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Column annotation=null;
        int result =0;

        try {
            // 拼接sql语句
            String sql="INSERT INTO "+t.getMethod("getTableName").invoke(t.newInstance())+"(";
            for (int i = 1; i < fields.length; i++)
            {
                annotation = fields[i].getAnnotation(Column.class);
                if (i == 1) {
                    sql += annotation.value();
                    continue;
                }
                sql += ", " + annotation.value();
            }
            sql += ") values(?";
            for (int i = 2; i < fields.length; i++) {
                sql += ",?";
            }
            sql += ")";
            System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);

            for (int i = 1; i < fields.length; i++) {
                String methodName = "get" + fields[i].getName().toUpperCase().charAt(0)
                        + fields[i].getName().substring(1);
                Method method = t.getMethod(methodName);
                annotation = fields[i].getAnnotation(Column.class);
                String type = annotation.type();
                Object object1 = method.invoke(entity);
                if (type.equals("Integer")) {
                    if (object1 != null)
                        preparedStatement.setInt(i, (Integer) object1);
                    else
                        preparedStatement.setInt(i, 0);
                }
                if (type.equals("String")) {
                    if (object1 != null)
                        preparedStatement.setString(i, (String) object1);
                    else
                        preparedStatement.setString(i, null);
                }
                if (type.equals("Double")) {
                    if (object1 != null)
                        preparedStatement.setDouble(i, (Double) object1);
                    else
                        preparedStatement.setDouble(i, 0);
                }
//                if (type.equals("Date")) {
//                    if (object1 != null)
//                        preparedStatement.setDate(i, new java.sql.Date(((Date) object1).getTime()));
//                    else
//                        preparedStatement.setDate(i, null);
//                }
            }
            result = preparedStatement.executeUpdate();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeResource();
        return result;

    }

    //更改Entity
    public <T extends Entity> int updateEntityByCondition(Object object, String condition, Class<T> clazz) {
        int result = 0;
        @SuppressWarnings("unchecked")
        T entity = (T) object;
        Field[] fields = clazz.getDeclaredFields();
        Column column = null;
        String sql = "update " + entity.getTableName() + " set id=";
        String methodName = "get";
        String columnName = "";
        String type = "";

        try {
            methodName += fields[0].getName().toUpperCase().charAt(0) + fields[0].getName().substring(1);

            Object object1 = clazz.getMethod(methodName).invoke(entity);
            if (object1 != null) {
                sql += (Integer) object1;
            }
            for (int i = 1; i < fields.length; i++) {
                object1 = null;
                methodName = "get";
                column = fields[i].getAnnotation(Column.class);
                columnName = column.value();
                type = column.type();
                methodName += fields[i].getName().toUpperCase().charAt(0) + fields[i].getName().substring(1);
                object1 = clazz.getMethod(methodName).invoke(entity);
                if (type.equals("Integer")) {
                    if (object1 != null)
                        sql += ", " + columnName + "= " + (Integer) object1;
                }
                if (type.equals("String")) {
                    if (object1 != null)
                        sql += ", " + columnName + "= '" + (String) object1 + "'";
                }
                if (type.equals("Double")) {
                    if (object1 != null)
                        sql += ", " + columnName + "= " + (Double) object1;
                }
//                if (type.equals("Date")) {
//                    if (object1 != null)
//                        sql += ", " + columnName + "= '" + new java.sql.Date(((Date) object1).getTime()) + "'";
//                }
            }
            if (condition != null) {
                sql += " where " + condition;
            }
            System.out.println(sql);
            preparedStatement= connection.prepareStatement(sql);
            result = preparedStatement.executeUpdate();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeResource();
        return result;
    }


    //删除Entity
    public <T extends Entity> int deleteEntitys(Object[] ids, Class<T> clazz) {
        int result = 0;
        Integer[] newIds = (Integer[]) ids;

        for (Integer id : newIds) {
            try {
                String sql = "delete from " + clazz.getMethod("getTableName").invoke(clazz.newInstance()) + " where id="
                        + id;
                preparedStatement = connection.prepareStatement(sql);
                result += preparedStatement.executeUpdate();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        closeResource();
        return result;
    }

    private void closeResource() {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                System.out.println("PreparedStatement关闭失败");
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("ResultSet关闭失败");
            }
        }
    }
}
