package com.grey.dao;

import com.grey.bean.User;

public interface UserDao {

    User get(Integer id);

    void add(User user);

    void delete(Integer id);

    void update(User user);
}
