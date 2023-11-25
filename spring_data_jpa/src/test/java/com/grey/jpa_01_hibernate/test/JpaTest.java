package com.grey.jpa_01_hibernate.test;

import com.grey.beans.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JpaTest {
    EntityManagerFactory factory;

    @Before
    public void before() {

        // persistence.xml 文件应该被放置在应用程序的 META-INF 目录下。
        // META-INF 目录是 Java EE 规范定义的一个目录，用于存放应用程序的元数据信息，例如 persistence.xml、MANIFEST.MF 等文件
        // 需要注意的是，persistence.xml 文件的名称和位置都是固定的，不能更改
        factory = Persistence.createEntityManagerFactory("hibernateJPA");
    }

    @Test
    public void testCreate() {
        EntityManager em = factory.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Customer customer = new Customer();
        customer.setCustName("耐奥祖");
        customer.setCustAddress("冰封王座");

        em.persist(customer);
        tx.commit();

        Assert.assertEquals("耐奥祖",customer.getCustName());
        Assert.assertEquals("冰封王座",customer.getCustAddress());
    }


    @Test
    public void testRetrieve() {
        EntityManager em = factory.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();


        Customer customer = em.find(Customer.class, 1L);  // 立即查询
        System.out.println(customer);

        tx.commit();

        Assert.assertNotNull(customer);

    }



    @Test
    public void testRetrieve_lazy() {
        EntityManager em = factory.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();


        Customer customer = em.getReference(Customer.class, 3L); //  延迟查询
        System.out.println(customer);

        tx.commit();

        Assert.assertEquals("王五",customer.getCustName());
    }


    @Test
    public void testUpdate() {
        EntityManager em = factory.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Customer customer = new Customer();
        customer.setCustId(4L);
        customer.setCustName("钱七发");


        // 如果指定了主键： 执行更新 --> 先查询  看是否有变化
        //                          如果有变化则更新,没有变化就不更新
        // 如果没有指定了主键： 执行插入
        em.merge(customer);
        Assert.assertEquals("钱七发",customer.getCustName());

        tx.commit();
    }

    @Test
    public void testU_JPQL() {
        EntityManager em = factory.createEntityManager();


        EntityTransaction tx = em.getTransaction();
        tx.begin();

        String jpql = "UPDATE Customer set custName=:name where custId=:id";

        em.createQuery(jpql)
                .setParameter("name", "李四")
                .setParameter("id", 4L)
                .executeUpdate();

        tx.commit();


        Customer customer = em.getReference(Customer.class, 4L);
        Assert.assertEquals("李四",customer.getCustName());
    }


    @Test
    public void testU_SQL() {
        EntityManager em = factory.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        String sql = "UPDATE tb_customer set cust_name=:name where id=:id";
        em.createNativeQuery(sql)
                .setParameter("name", "王五")
                .setParameter("id", 5L)
                .executeUpdate();

        tx.commit();


        Customer customer = em.getReference(Customer.class, 5L);
        Assert.assertEquals("王五",customer.getCustName());
    }


    @Test
    public void testDelete() {
        EntityManager em = factory.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Customer customer = em.find(Customer.class, 8L);
        em.remove(customer);

        tx.commit();

        Assert.assertNotNull(customer);
    }
}
