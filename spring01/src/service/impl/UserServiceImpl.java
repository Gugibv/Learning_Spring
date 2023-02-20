package service.impl;

import dao.IUserDao;
import dao.impl.UserDaoImpl;
import pojo.User;
import service.IUserService;

public class UserServiceImpl implements IUserService {

    IUserDao dao;

    public IUserDao getDao() {
        return dao;
    }

    public void setDao(IUserDao dao) {
        this.dao = dao;
    }

    @Override
    public User getUsers() {
        return dao.getUser();
    }
}
