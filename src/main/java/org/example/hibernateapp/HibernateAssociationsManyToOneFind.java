package org.example.hibernateapp;

import jakarta.persistence.EntityManager;
import org.example.hibernateapp.entity.Customer;
import org.example.hibernateapp.entity.Invoice;
import org.example.hibernateapp.util.JpaUtil;

public class HibernateAssociationsManyToOneFind {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            Customer customer = em.find(Customer.class, 1L);

            Invoice invoice1 = new Invoice("Macbook Pro", 2000L);
            invoice1.setCustomer(customer);
            em.persist(invoice1);

            System.out.println(invoice1);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
