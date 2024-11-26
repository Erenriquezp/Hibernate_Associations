package org.example.hibernateapp;

import jakarta.persistence.EntityManager;
import org.example.hibernateapp.entity.Student;
import org.example.hibernateapp.util.JpaUtil;

import java.util.List;

public class HibernateFetchManyToMany {
    public static void main(String[] args) {
        System.out.println("Hello Hibernate!");

        EntityManager em = JpaUtil.getEntityManager();

        List<Student> students = em.createQuery("select distinct  s from Student s left outer join fetch s.courses", Student.class).getResultList();
        students.forEach(System.out::println);

        em.close();
    }
}
