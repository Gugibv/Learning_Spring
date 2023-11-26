package com.grey.tests.jpa_02;




import com.grey.config.SpringDataJPAConfig;
import com.grey.beans.Customer;
import com.grey.repositories.CustomerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@ContextConfiguration(classes = SpringDataJPAConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class JpqlTest {

    // jdk动态代理的实例
    @Autowired
    CustomerRepository repository;

    @Test
    public  void testRetrieve(){
        List<Customer> customer = repository.findCustomerByCustName("徐庶");

        Assert.assertNotNull(customer);
        System.out.println(customer);
    }



}
