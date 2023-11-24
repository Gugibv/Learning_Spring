package com.grey.tests;


import com.alibaba.druid.pool.DruidDataSource;
import com.grey.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class JDBCTest {

    ClassPathXmlApplicationContext ioc;
    @Before
    public  void before(){
        ioc=new ClassPathXmlApplicationContext("classpath:spring.xml");
    }


    @Test
    public void getTotalNumFromTable(){
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        Long totalNum = jdbcTemplate.queryForObject("select count(*) from t_user", Long.class);
        assertNotNull(totalNum);
        System.out.println(totalNum);
    }


    @Test
    public void getUserById(){
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);

        // 数据库字段名和属性名一样 利用BeanPropertyRowMapper
        User user = jdbcTemplate.queryForObject("select * from t_user where id=1", new BeanPropertyRowMapper<>(User.class));
        assertNotNull(user);
        System.out.println(user);
    }

    @Test
    public void getUserList(){
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);

        // 数据库字段名和属性名一样 利用BeanPropertyRowMapper
        List<User> userList = jdbcTemplate.query("select * from t_user", new BeanPropertyRowMapper<>(User.class));
        assertNotNull(userList);
        System.out.println(userList);
    }


    @Test
    public void addNewUser(){
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);

        int result = jdbcTemplate.update("insert into t_user(realname,cardno,balance) values (?,?,?)", "王麻子","12345677",800);
        assertEquals(1,result);

    }

    @Test
    public void updateBalanceByCard(){

        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);

        int result = jdbcTemplate.update("update t_user set balance=balance+200 where cardno=?", "12345677");

        assertEquals(1,result);
    }

    @Test
    public void namedParameterJdbcTemplateExample(){
        NamedParameterJdbcTemplate jdbcTemplate = ioc.getBean(NamedParameterJdbcTemplate.class);

        Map<String,Object> map=new HashMap<>();
        map.put("cardNo","12345677");

        int result = jdbcTemplate.update("delete from t_user where cardno= :cardNo",map);
        assertEquals(1,result);
    }


}
