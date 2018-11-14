package be.intecbrussel.blogProject.dao;

import be.intecbrussel.blogProject.beans.BlogPostBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Represents the dataLayer of BlogPostBean class
 *
 * @author Mr. Black
 * @see be.intecbrussel.blogProject.beans.BlogPostBean
 */
public class BlogPostDAO {

    // Variables
    private EntityManager em;
    private EntityTransaction et;

    // Safe
    public void safeBlogPost(BlogPostBean blogPost){
        System.out.println("Saving Blog Post DAO...");
        em = EMProvidor.getEntityManager();
        et = em.getTransaction();
        et.begin();
        em.persist(blogPost);
        et.commit();
    }
}
