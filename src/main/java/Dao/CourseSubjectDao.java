/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Course_Subject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author TAN
 */
public class CourseSubjectDao {

    private EntityManager em;

    public CourseSubjectDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("fresherService");
        em = emf.createEntityManager();
    }

    public List checkCourseSubject(String courseId, String subjectId) {
        em.clear();
        em.getTransaction().begin();
        List<Course_Subject> list = em.createQuery("select cs from Course_Subject cs where cs.makh = ?1 and cs.mamon = ?2")
                .setParameter(1, courseId).setParameter(2, subjectId)
                .getResultList();
        em.getTransaction().commit();
        return list;
    }

}
