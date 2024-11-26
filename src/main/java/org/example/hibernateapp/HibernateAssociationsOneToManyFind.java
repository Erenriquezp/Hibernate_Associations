package org.example.hibernateapp;

import jakarta.persistence.EntityManager;
import org.example.hibernateapp.entity.Address;
import org.example.hibernateapp.entity.Customer;
import org.example.hibernateapp.util.JpaUtil;

public class HibernateAssociationsOneToManyFind {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            Customer customer = em.find(Customer.class, 1L);
            Address a1 = new Address("Main Street", 123);
            Address a2 = new Address("Second Street", 456);
            customer.getAddresses().add(a1);
            customer.getAddresses().add(a2);
            em.merge(customer);

            em.getTransaction().commit();
            System.out.println(customer);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
