package com.grey.dao;

import com.grey.entity.User;

public interface IUserDao {
    User getUser();

    void sub();

    void save();

}
