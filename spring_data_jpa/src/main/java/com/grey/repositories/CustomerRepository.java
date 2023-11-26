package com.grey.repositories;


import com.grey.beans.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long>{

    @Query("FROM Customer where custName=:custName ")
    List<Customer> findCustomerByCustName(@Param("custName") String custName);


}
