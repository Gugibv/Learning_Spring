package com.grey.bean.instantiate;

import com.grey.bean.User;
import org.springframework.beans.factory.FactoryBean;

public class UserBeanFactoryImpl implements FactoryBean<User> {


    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
