package dao.impl;

import dao.IUserDao;
import pojo.User;

public class UserDaoImpl implements IUserDao {
    @Override
    public User getUser() {
        User user = new User();
        user.setId(123);
        user.setUsername("Epiphany");
        return user;
    }
}
