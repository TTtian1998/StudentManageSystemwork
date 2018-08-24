package com.TianZeXin.service.iml;

import com.TianZeXin.dao.EntityDao;
import com.TianZeXin.entity.User;
import com.TianZeXin.flection.Resourse;
import com.TianZeXin.service.UserService;

public class UserServiceIml implements UserService {
    @Resourse(value = "dao.EntityDao")
    private static EntityDao dao;

    @Override
    public boolean login(String username, String password) {
        String condition="";
        if(username !=null && !username.isEmpty()){
            condition +=" and username='"+username+"'";
        }
        if (password != null && !password.isEmpty()) {
            condition += " and password='" + password + "'";
        }
        if (condition.equals("")) {
            return false;
        }
        User user2=dao.getEntityByCondition(condition,User.class);
        if(user2==null){
            return false;
        }
        return true;
    }

    @Override
    public boolean regist(String username, String password) {
        User user =new User();
        user.setUsername(username);
        user.setPassword(password);

        int result=dao.saveEntity(user,User.class);
        if(result>0){
            return true;
        }
        return false;
    }
}
