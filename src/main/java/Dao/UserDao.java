/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author TAN
 */
public class UserDao {

    private EntityManager em;

    public UserDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("fresherService");
        em = emf.createEntityManager();
    }

    public boolean valid(User u) {
        boolean result = false;
        System.out.println("username = " + u.getUsername() + u.getPassword());
        if (em.createQuery("SELECT u FROM User u WHERE u.username = '"
                + u.getUsername() + "' and u.password = '" + u.getPassword()
                + "'").getResultList().size() == 0) {
            result = false;
        } else {
            result = true;
        }
        return result;
    }

}
