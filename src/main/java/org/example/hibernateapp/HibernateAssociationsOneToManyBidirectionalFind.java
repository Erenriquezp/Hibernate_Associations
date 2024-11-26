package org.example.hibernateapp;

import jakarta.persistence.EntityManager;
import org.example.hibernateapp.entity.Customer;
import org.example.hibernateapp.entity.Invoice;
import org.example.hibernateapp.util.JpaUtil;

public class HibernateAssociationsOneToManyBidirectionalFind {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        try {

            em.getTransaction().begin();

            Customer customer = em.find(Customer.class, 1L);

            Invoice i1 = new Invoice("First invoice", 1000L);
            Invoice i2 = new Invoice("Second invoice", 2000L);
            customer.addInvoice(i1).addInvoice(i2);

//            em.merge(customer);
            em.getTransaction().commit();
            System.out.println(customer);

            em.getTransaction().begin();
//          Invoice invoice = em.find(Invoice.class, 1L);
            Invoice invoice = new Invoice("First invoice", 1000L);
            invoice.setId(1L);
            customer.removeInvoice(invoice);
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
