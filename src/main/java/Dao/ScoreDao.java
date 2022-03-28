/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Score;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author TAN
 */
public class ScoreDao {

    private EntityManager em;

    public ScoreDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("fresherService");
        em = emf.createEntityManager();
    }

    public void deleteScore(int stId) {
        em.getTransaction().begin();
        em.createQuery("delete from Score where mahv = ?").setParameter(1, stId).executeUpdate();
        em.getTransaction().commit();
    }

    public List listOne(int stId, String courseId, String subjectId) {
        em.clear();
        em.getTransaction().begin();
        List<Score> list = em.createQuery("select sc from Score sc where sc.mahv = ?1 and sc.makh = ?2 and sc.mamon = ?3")
                .setParameter(1, stId).setParameter(2, courseId).setParameter(3, subjectId)
                .getResultList();
        em.getTransaction().commit();
        return list;
    }

    public List listSubNotStudied(int stId, String courseId) {
        em.clear();
        em.getTransaction().begin();
        List list = em.createQuery("select c.makh\n"
                + "from Course c\n"
                + "inner join Course_Subject cs\n"
                + "on c.makh = cs.makh\n"
                + "inner join Subject s\n"
                + "on cs.mamon = s.mamon\n"
                + "where kh.makh = ?2 and s.tenmon not in(\n"
                + "select s.tenmon\n"
                + "from Score sc\n"
                + "inner join Subject s\n"
                + "on sc.mamon = s.mamon\n"
                + "where sc.mahv = ?1 and sc.makh = ?2\n"
                + ")")
                .setParameter(1, stId).setParameter(2, courseId)
                .getResultList();
        em.getTransaction().commit();
        return list;
    }

    public List listBangdiem(int stId) {
        em.clear();
        em.getTransaction().begin();
        List<Object[]> list = em.createQuery("select sc.mahv, st.ten, c.tenkh, s.tenmon, sc.diemlt, sc.diemth "
                + "from Score sc, Student st, Subject s, Course c where sc.mahv = ?1 "
                + "and st.mahv = ?1 and sc.mamon = s.mamon and sc.makh = c.makh")
                .setParameter(1, stId)
                .getResultList();
        System.out.println("idd ===============" + stId);
        em.getTransaction().commit();
        return list;
    }

    public void addScore(Score sc) {
        em.getTransaction().begin();
        em.persist(sc);
        em.getTransaction().commit();
    }

}
