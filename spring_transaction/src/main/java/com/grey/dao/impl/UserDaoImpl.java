package com.grey.dao.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.grey.dao.IUserDao;
import com.grey.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements IUserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DruidDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User getUser() {
        return jdbcTemplate.queryForObject("select * from t_user where id=1",new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void sub() {
        jdbcTemplate.update("update t_user set balance=balance-20 where id=1");
    }

    @Override
    public void save() {
        jdbcTemplate.update("update t_user set balance=balance+20 where id=2");
    }
}
