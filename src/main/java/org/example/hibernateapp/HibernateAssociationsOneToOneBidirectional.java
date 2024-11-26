package org.example.hibernateapp;

import jakarta.persistence.EntityManager;
import org.example.hibernateapp.entity.Customer;
import org.example.hibernateapp.entity.CustomerDetail;
import org.example.hibernateapp.util.JpaUtil;

public class HibernateAssociationsOneToOneBidirectional {
    public static void main(String[] args) {
        System.out.println("Hello Hibernate!");

        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Customer customer = new Customer("Hinata", "Hyuga");
            customer.setPaymentMethod("PayPal");

            CustomerDetail customerDetail = new CustomerDetail(true, 1000L);

            customer.addCustomerDetail(customerDetail);

            em.persist(customer);

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
