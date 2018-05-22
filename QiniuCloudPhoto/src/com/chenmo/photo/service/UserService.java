package com.chenmo.photo.service;

import com.chenmo.photo.domain.User;
import com.chenmo.photo.util.DBUtils;

import java.util.List;

public class UserService {

    public User getUserByUsername(String username) {
        String sql = "select id, username, password from user where username = ?";
        String[] parameters = {username};
        List<Object[]> users = DBUtils.query(sql, parameters);
        if (users.size() == 0) {
            return null;
        } else {
            Object[] objects = users.get(0);
            return objects == null ? null : new User(Integer.parseInt(objects[0].toString()), objects[1].toString(), objects[2].toString(), null);
        }
    }

    public void addUser(User user) {
        String[] sqls = {"insert into user(username, password) values(?, ?)"};
        String[][] parameters = {{user.getUsername(), user.getPassword()}};
        DBUtils.updates(sqls, parameters);
    }


}
