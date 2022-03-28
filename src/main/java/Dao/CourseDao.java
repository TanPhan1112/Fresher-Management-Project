/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Course;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author TAN
 */
public class CourseDao {

    private EntityManager em;

    public CourseDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("fresherService");
        em = emf.createEntityManager();
    }

    public List listOne(String courseId) {
        em.clear();
        em.getTransaction().begin();
        List<Course> list = em.createQuery("select c from Course c where c.makh = ?1")
                .setParameter(1, courseId)
                .getResultList();
        em.getTransaction().commit();
        return list;
    }

    public List checkCourseId(String courseId, String courseName) {
        em.clear();
        em.getTransaction().begin();
        List<Course> list = em.createQuery("select c from Course c where c.makh = ?1 or c.tenkh = ?2")
                .setParameter(1, courseId).setParameter(2, courseName)
                .getResultList();
        em.getTransaction().commit();
        return list;
    }

    public void deleteStudent(Course c) {
        Course currC = em.find(Course.class, c.getMakh());
        em.getTransaction().begin();
        em.remove(currC);
        em.getTransaction().commit();
    }

    public void add(Course c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }

}
