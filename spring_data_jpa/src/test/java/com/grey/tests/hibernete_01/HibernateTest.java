package com.grey.tests.hibernete_01;


import com.grey.beans.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class HibernateTest {
    // Session工厂  Session:数据库会话  代码和数据库的一个桥梁
    private SessionFactory sessionFactory;

    @Before
    public void init() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("/hibernate.cfg.xml").build();

        //2. 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    @Test
    public void testCreate(){
        // session进行持久化操作
        try(Session session = sessionFactory.openSession()){
            Transaction tx = session.beginTransaction();

            Customer customer = new Customer();
            customer.setCustName("徐庶");
            customer.setCustAddress("地址");
            session.save(customer);


            //  在 Hibernate 中，所有的数据库操作都是在事务（Transaction）中执行的。在这个测试方法中，Transaction 对象用于控制数据库操作的提交和回滚。

            //  tx.commit() 用于提交当前事务，即将所有对数据库的修改保存到数据库中，并释放数据库连接。
            //  如果你在测试方法中执行完所有数据库操作之后不调用 tx.commit()，
            //  那么对数据库的修改将不会被保存，也不会释放数据库连接，这可能会导致数据库连接池耗尽或者出现其他问题。
            tx.commit();


            Assert.assertNotNull(customer);
            System.out.println(customer);
        }

    }



    @Test
    public void testRetrieve(){

        try(Session session = sessionFactory.openSession()){
            Transaction tx = session.beginTransaction();
            Customer customer = session.find(Customer.class, 1L);
            Assert.assertNotNull(customer);
            System.out.println(customer);
            tx.commit();
        }

    }


    @Test
    public void testRetrieve_lazy(){

        try(Session session = sessionFactory.openSession()){
            Transaction tx = session.beginTransaction();

            // 使用 session.load() 方法，因此实体并没有立即被加载，而是在访问该实体的属性时才会触发实体的加载。这就是懒加载
            Customer customer = session.load(Customer.class, 1L);

            Assert.assertNotNull(customer);
            System.out.println(customer);
            tx.commit();
        }
    }


    @Test
    public void testUpdate(){

        try(Session session = sessionFactory.openSession()){
            Transaction tx = session.beginTransaction();

            Customer customer = new Customer();
            customer.setCustId(1L);
            customer.setCustName("阿尔萨斯");

            session.saveOrUpdate(customer);

            Assert.assertEquals("阿尔萨斯",customer.getCustName());
            Assert.assertNull(customer.getCustAddress());
            tx.commit();
        }

    }


    @Test
    public void testDelete(){

        try(Session session = sessionFactory.openSession()){
            Transaction tx = session.beginTransaction();

            Customer customer = new Customer();
            customer.setCustId(2L);

            session.remove(customer);

            Assert.assertNull(customer.getCustAddress());

            tx.commit();
        }
    }


    @Test
    public void testR_HQL(){

        try(Session session = sessionFactory.openSession()){
            Transaction tx = session.beginTransaction();

            String hql=" FROM Customer where custId=:id";

            List<Customer> resultList = session.createQuery(hql, Customer.class)
                    .setParameter("id",1L)
                    .getResultList();


            Assert.assertNotNull(resultList);
            System.out.println(resultList);

            tx.commit();
        }
    }

}
