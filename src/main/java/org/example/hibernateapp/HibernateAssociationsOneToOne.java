package org.example.hibernateapp;

import jakarta.persistence.EntityManager;
import org.example.hibernateapp.entity.Customer;
import org.example.hibernateapp.entity.CustomerDetail;
import org.example.hibernateapp.util.JpaUtil;

public class HibernateAssociationsOneToOne {
    public static void main(String[] args) {
        System.out.println("Hello HibernateAssociationsOneToOne");

        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            Customer customer = new Customer("Yukino", "Yukinoshita");
            customer.setPaymentMethod("Credit");
            em.persist(customer);

            CustomerDetail customerDetail = new CustomerDetail(true, 1000L);
            em.persist(customerDetail);
            customer.setCustomerDetail(customerDetail);
            em.getTransaction().commit();

            System.out.println(customer);

        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

    }
}
