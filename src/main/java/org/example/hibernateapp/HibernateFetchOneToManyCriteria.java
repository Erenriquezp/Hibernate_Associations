package org.example.hibernateapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import org.example.hibernateapp.entity.Customer;
import org.example.hibernateapp.util.JpaUtil;

import java.util.List;

public class HibernateFetchOneToManyCriteria {
    public static void main(String[] args) {
        System.out.println("Hello Hibernate!");
        EntityManager em = JpaUtil.getEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> query = cb.createQuery(Customer.class);
        Root<Customer> customerRoot = query.from(Customer.class);

        customerRoot.fetch("addresses", JoinType.LEFT);
        customerRoot.fetch("customerDetail", JoinType.LEFT);
        query.select(customerRoot).distinct(true);
        List<Customer> customers = em.createQuery(query).getResultList();
        customers.forEach(customer -> {
            System.out.println("Customer: " + customer.getName() + ", Addresses: "
                    + customer.getAddresses() + ", CustomerDetail: " + customer.getCustomerDetail());
        });

        em.close();
    }
}
