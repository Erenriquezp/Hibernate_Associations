package org.example.hibernateapp;

import jakarta.persistence.EntityManager;
import org.example.hibernateapp.entity.Course;
import org.example.hibernateapp.entity.Student;
import org.example.hibernateapp.util.JpaUtil;

public class HibernateAssociationsManyToManyFind {
    public static void main(String[] args) {
        System.out.println("Hello Hibernate!");

        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Student student = em.find(Student.class, 1L);
            Student student2 = em.find(Student.class, 2L);

//            Course course = new Course("Java", "Wendy Marvell");
//            Course course2 = new Course("Python", "Erza Scarlet");

            Course course = em.find(Course.class, 1L);
            Course course2 = em.find(Course.class, 2L);

            student.getCourses().add(course);
            student.getCourses().add(course2);
            student2.getCourses().add(course);

            em.getTransaction().commit();

            System.out.println(student);
            System.out.println(student2);

            em.getTransaction().begin();
            Course course3 = em.find(Course.class, 2L);
            student.getCourses().remove(course3);
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
