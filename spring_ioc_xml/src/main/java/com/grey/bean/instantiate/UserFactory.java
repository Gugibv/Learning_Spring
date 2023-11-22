package com.grey.bean.instantiate;

import com.grey.bean.User;

public class UserFactory {
    //必须是静态方法
    public static User getUserBean(){
        return new User();
    }

    public User getUserBean(Integer id, String username, String realname) {
        return new User(id,username,realname);
    }
}
