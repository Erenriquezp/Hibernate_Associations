package org.example.hibernateapp;

import jakarta.persistence.EntityManager;
import org.example.hibernateapp.entity.Address;
import org.example.hibernateapp.entity.Customer;
import org.example.hibernateapp.util.JpaUtil;

public class HibernateAssociationsOneToMany {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            Customer customer = new Customer("Jeane", "D'Arc");
            customer.setPaymentMethod("Debit");
            Address a1 = new Address("Main Street", 123);
            Address a2 = new Address("Second Street", 456);
            customer.getAddresses().add(a1);
            customer.getAddresses().add(a2);
            em.persist(customer);

            em.getTransaction().commit();
            System.out.println(customer);

            em.getTransaction().begin();
            customer = em.find(Customer.class, customer.getId());
            customer.getAddresses().remove(a1);
            em.getTransaction().commit();
            System.out.println(customer);

            em.getTransaction().begin();
            a2 = em.find(Address.class, a2.getId());
            customer.getAddresses().remove(a2);
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
