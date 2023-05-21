package com.amigoscode.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}



///   BEAN   /// Class
//      a    ///    Interface  CustomerRepository
//      b    ///    Class       CustomerService  ( CustomerRepository repository )
//      c      /    Class       CustomerServiceNormal ( CustomerRepository repository )
