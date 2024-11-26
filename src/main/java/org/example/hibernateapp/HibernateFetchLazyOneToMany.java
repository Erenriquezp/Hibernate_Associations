package org.example.hibernateapp;

import jakarta.persistence.EntityManager;
import org.example.hibernateapp.entity.Customer;
import org.example.hibernateapp.util.JpaUtil;

public class HibernateFetchLazyOneToMany {
    public static void main(String[] args) {
        System.out.println("Hello Hibernate!");
        EntityManager em = JpaUtil.getEntityManager();

        Customer customer = em.find(Customer.class, 1L);
        System.out.println(customer);
        em.close();
    }
}
