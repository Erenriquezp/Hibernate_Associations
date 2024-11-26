package org.example.hibernateapp;

import jakarta.persistence.EntityManager;
import org.example.hibernateapp.entity.Course;
import org.example.hibernateapp.entity.Student;
import org.example.hibernateapp.util.JpaUtil;

public class HibernateAssociationsManyToMany {
    public static void main(String[] args) {
        System.out.println("Hello Hibernate!");

        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Student student = new Student("Touka", "Kirishima");
            Student student2 = new Student("Rem", "Rin");

            Course course = new Course("Java", "Wendy Marvell");
            Course course2 = new Course("Python", "Erza Scarlet");

            student.getCourses().add(course);
            student.getCourses().add(course2);
            student2.getCourses().add(course);

            em.persist(student);
            em.persist(student2);

            em.getTransaction().commit();

            System.out.println(student);
            System.out.println(student2);

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
