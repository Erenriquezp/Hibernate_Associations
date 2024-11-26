package org.example.hibernateapp;

import jakarta.persistence.EntityManager;
import org.example.hibernateapp.entity.Customer;
import org.example.hibernateapp.util.JpaUtil;

public class HibernateFetchLazyOneToManyJoinFetch {
    public static void main(String[] args) {
        System.out.println("Hello Hibernate!");
        EntityManager em = JpaUtil.getEntityManager();

        Customer customer = em.createQuery("select c from Customer c left outer join fetch c.addresses left join fetch c.customerDetail where c.id=:id", Customer.class)
                .setParameter("id", 1L)
                .getSingleResult();

        System.out.println(customer);
        em.close();
    }
}
