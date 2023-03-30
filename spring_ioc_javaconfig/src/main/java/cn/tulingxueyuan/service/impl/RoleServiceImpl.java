package cn.tulingxueyuan.service.impl;

import cn.tulingxueyuan.beans.Role;
import cn.tulingxueyuan.dao.UserDao;
import cn.tulingxueyuan.service.BaseService;
import cn.tulingxueyuan.service.RoleService;
import cn.tulingxueyuan.service.UserService;
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
