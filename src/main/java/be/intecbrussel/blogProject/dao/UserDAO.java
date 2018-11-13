package be.intecbrussel.blogProject.dao;

import be.intecbrussel.blogProject.beans.UserBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDAO {

    // Variables
    private EntityManager em = EMProvidor.getEntityManager();
    private EntityTransaction et = em.getTransaction();

    // Safe
    public void saveUser(UserBean user){
        System.out.println("Saving user DAO...");
        et.begin();
        em.persist(user);
        et.commit();
    }


    // Read



    // Delete

    // Queries (private)
    private TypedQuery<UserBean> getUserByLastNameQuery(String lastName){
        TypedQuery<UserBean> query = em.createQuery("SELECT user FROM UserBean as user where user.lastName=:last",UserBean.class);
        query.setParameter("last",lastName);
        return query;
    }

    // ResultSets
    public List<UserBean> getUserByLastName(String lastName){
        return getUserByLastNameQuery(lastName).getResultList();
    }
}
