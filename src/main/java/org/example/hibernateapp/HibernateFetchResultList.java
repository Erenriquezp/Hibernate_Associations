package org.example.hibernateapp;

import jakarta.persistence.EntityManager;
import org.example.hibernateapp.entity.Customer;
import org.example.hibernateapp.util.JpaUtil;

import java.util.List;

public class HibernateFetchResultList {
    public static void main(String[] args) {
        System.out.println("Hello Hibernate!");
        EntityManager em = JpaUtil.getEntityManager();

        List<Customer> customers = em.createQuery("select distinct c from Customer c " +
                        "left outer join fetch c.addresses " +
                        "left outer join fetch c.customerDetail", Customer.class)
                .getResultList();

        customers.forEach(System.out::println);
        em.close();
    }
}
