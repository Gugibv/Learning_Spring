package cn.grey.service.impl;

import cn.grey.dao.UserDao;
import cn.grey.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl  implements RoleService {
    @Autowired
    UserDao userDao;

    public void getBean() {
        System.out.println("RoleServiceImpl");
        userDao.getUser();
    }
}
