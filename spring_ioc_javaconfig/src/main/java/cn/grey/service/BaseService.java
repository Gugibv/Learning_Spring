package cn.grey.service;


import org.springframework.stereotype.Component;

@Component
public interface BaseService<T>{

    T getBean();

    //公共的增删查改
}
