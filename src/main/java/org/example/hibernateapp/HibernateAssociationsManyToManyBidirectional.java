package org.example.hibernateapp;

import jakarta.persistence.EntityManager;
import org.example.hibernateapp.entity.Course;
import org.example.hibernateapp.entity.Student;
import org.example.hibernateapp.util.JpaUtil;

public class HibernateAssociationsManyToManyBidirectional {
    public static void main(String[] args) {
        System.out.println("Hello Hibernate!");

        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Student student = new Student("Touka", "Kirishima");
            Student student2 = new Student("Rem", "Rin");

            Course course = new Course("Java", "Wendy Marvell");
            Course course2 = new Course("Python", "Erza Scarlet");

            student.addCourse(course);
            student.addCourse(course2);
            student2.addCourse(course);

            em.persist(student);
            em.persist(student2);

            em.getTransaction().commit();

            System.out.println(student);
            System.out.println(student2);

            em.getTransaction().begin();
            Course course3 = new Course("Java", "Wendy Marvell");
            course3.setId(5L);
            student.removeCourse(course3);
            em.getTransaction().commit();

            System.out.println(student);

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
