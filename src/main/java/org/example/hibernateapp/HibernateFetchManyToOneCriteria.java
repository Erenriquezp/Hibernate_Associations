package org.example.hibernateapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.example.hibernateapp.entity.Customer;
import org.example.hibernateapp.entity.Invoice;
import org.example.hibernateapp.util.JpaUtil;

import java.util.List;

public class HibernateFetchManyToOneCriteria {
    public static void main(String[] args) {
        System.out.println("Hello Hibernate!");
        EntityManager em = JpaUtil.getEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Invoice> query = cb.createQuery(Invoice.class);
        Root<Invoice> invoiceRoot = query.from(Invoice.class);
        Join<Invoice, Customer> customer = (Join) invoiceRoot.fetch("customer", JoinType.LEFT);
        customer.fetch("customerDetail", JoinType.LEFT);

        query.select(invoiceRoot).where(cb.equal(customer.get("id"), 1L));
        List<Invoice> invoices = em.createQuery(query).getResultList();
        invoices.forEach(invoice -> System.out.println(invoice.getDescription() + ", Customer: " + invoice.getCustomer().getName()));

        em.close();
    }
}
