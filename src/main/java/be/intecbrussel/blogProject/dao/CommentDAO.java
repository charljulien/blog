package be.intecbrussel.blogProject.dao;

import be.intecbrussel.blogProject.beans.CommentBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Represents dataLayer of CommentBean class
 *
 * @author Mr. Black
 * @see CommentBean
 * @see be.intecbrussel.blogProject.service.interfaces.CommentServiceInterface
 */
public class CommentDAO {

    // Variables
    private EntityManager em;
    private EntityTransaction et;


    /**
     * Saves a comment to the DB
     */
    public void safeComment(CommentBean comment) {
        System.out.println("Saving Comment DAO...");
        em = EMProvidor.getEntityManager();
        et = em.getTransaction();
        et.begin();
        em.persist(comment);
        et.commit();
    }

}
