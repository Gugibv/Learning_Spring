package com.grey.service;

import com.grey.bean.User;

public interface UserService {
    User get(Integer id);

    String getName(Integer id);

    void add(User user);

    void delete(Integer id);

    void update(User user);
}
