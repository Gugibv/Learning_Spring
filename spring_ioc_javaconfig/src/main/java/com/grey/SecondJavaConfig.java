package com.grey;

import com.grey.beans.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
public class SecondJavaConfig {
    @Bean
    public User userSpecial(){
        User user = new User();
        user.setName("耐奥祖");
        return user;
    }
}
