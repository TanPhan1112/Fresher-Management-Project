/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author TAN
 */
public class StudentDao {

    private EntityManager em;

    public StudentDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("fresherService");
        em = emf.createEntityManager();
    }

    public void add(Student st) {
        em.getTransaction().begin();
        em.persist(st);
        em.getTransaction().commit();
    }

    public List<Student> findAll() {
        em.clear();//Clear old entity
        em.getTransaction().begin();
        List<Student> result = em.createQuery("from Student", Student.class).getResultList();
        em.getTransaction().commit();
        return result;
    }

//    public void refresh(int id) {
//        em.getTransaction().begin();
//        Student st = em.find(Student.class, id);
//        if (st != null) {//not db ==> blank page
//            em.refresh(st);//Synchronize entity DB, refresh must not NULL
//        }
//        em.getTransaction().commit();
//    }
    public List listOne(int stId) {
        em.clear();
        em.getTransaction().begin();
        List<Student> list = em.createQuery("SELECT s FROM Student s WHERE s.mahv = ?1")
                .setParameter(1, stId)
                .getResultList();
        em.getTransaction().commit();
        return list;
    }

    public List findName(String name) {
        em.getTransaction().begin();
        //Like
        Query sql = em.createQuery("Select s " + "from Student s " + "where s.ten LIKE ?1")
                .setParameter(1, "%" + name + "%");
        List<Student> list = (List<Student>) sql.getResultList();
        em.getTransaction().commit();
        return list;
    }

    public void deleteStudent(Student s) {
        Student currSt = em.find(Student.class, s.getMahv());
        em.getTransaction().begin();
        em.remove(currSt);
        em.getTransaction().commit();
    }

    public void updateStudent(Student s) {
        Student currSt = em.find(Student.class, s.getMahv());
        em.getTransaction().begin();
        currSt.setTen(s.getTen());
        currSt.setNgaysinh(s.getNgaysinh());
        currSt.setGioitinh(s.getGioitinh());
        currSt.setDiachi(s.getDiachi());
        currSt.setDt(s.getDt());
        currSt.setEmail(s.getEmail());
        em.getTransaction().commit();
    }

    public List checkPhoneEmail(int phone, String email) {
        em.getTransaction().begin();
        Query sql = em.createQuery("Select s from Student s where s.dt = ?1 or s.email = ?2")
                .setParameter(1, phone)
                .setParameter(2, email);
        List<Student> list = (List<Student>) sql.getResultList();
        em.getTransaction().commit();
        return list;
    }

}
