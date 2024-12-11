package org.example.hibernateapp.homework;

import jakarta.persistence.*;

import java.util.List;

public class EmployeeService {

    @PersistenceContext
    private EntityManager entityManager;

    // Método para obtener empleados y sus direcciones
    public List<Employee> getEmployeesWithAddresses() {
        String jpql = "SELECT e FROM Employee e JOIN FETCH e.addresses";
        TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);
        return query.getResultList();
    }

    public List<Employee> getEmployeesByCity(String city) {
        String jpql = "SELECT e FROM Employee e JOIN FETCH e.addresses a WHERE a.city = :city";
        TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);
        query.setParameter("city", city);
        return query.getResultList();
    }

}
