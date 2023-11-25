package com.grey.beans;
import javax.persistence.*;

@Entity
@Table(name = "tb_customer")
public class Customer {

    /**
     * @GeneratedValue:配置主键的生成策略
     *      strategy
     *          GenerationType.IDENTITY ：自增，适用于 MySQL 数据库。要求底层数据库必须能够支持自动增长（底层数据库支持的自动增长方式，对id自增）
     *          GenerationType.SEQUENCE : 序列，适用于 Oracle 数据库。要求底层数据库必须支持序列
     *          GenerationType.TABLE : jpa提供的一种机制，通过一张数据库表的形式帮助我们完成主键自增
     *          GenerationType.AUTO ： 由程序自动的帮助我们选择主键生成策略
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "customer_seq")
    @SequenceGenerator(name ="customer_seq" ,sequenceName = "customer_id_seq",allocationSize = 1)
    @Column(name = "id")
    private Long custId;

    @Column(name = "cust_name")
    private String custName;

    @Column(name="cust_address")
    private String custAddress;

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custAddress='" + custAddress + '\'' +
                '}';
    }
}
