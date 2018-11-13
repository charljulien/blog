package be.intecbrussel.blogProject.dao;

import be.intecbrussel.blogProject.beans.CommentBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CommentDAO {

    // Variables
    private EntityManager em = EMProvidor.getEntityManager();
    private EntityTransaction et = em.getTransaction();


    // Safe
    public void safeComment(CommentBean comment){
        System.out.println("Saving Comment DAO...");
        et.begin();
        em.persist(comment);
        et.commit();
    }

}
