package be.intecbrussel.blogProject.dao;

import be.intecbrussel.blogProject.beans.BlogPostBean;
import com.mysql.jdbc.PreparedStatement;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Represents the dataLayer of BlogPostBean class
 *
 * @author Mr. Black
 * @see be.intecbrussel.blogProject.beans.BlogPostBean
 */
public class BlogPostDAO {

    Connection connection=null;
    private static final String UPDATE = "UPDATE BlogPost SET blogMessage=?, likeBlogCounter=?, date=?, WHERE id=?";
    private static final String DELETE = "DELETE FROM BlogPost WHERE id=?";
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
    /**
     * Update blog message in DB
     * Mr.Brown
     * @param blogPost
     */

    //Update
    public void updateBlogPost(BlogPostBean blogPost){


        try {
            PreparedStatement p = (PreparedStatement) connection.prepareStatement(UPDATE);
            p.setString(1,blogPost.getBlogMessage());


            p.executeUpdate();
            p.close();

            System.out.println("Blog message " + blogPost.getId() + "was updated");

        }catch ( SQLException e){
            throw new RuntimeException(e);
        }

    }

    /**
     * Delete blog message in DB
     * Mr.Brown
     * @param id
     */
    // Delete

    public void delete(int id){


        try {
            PreparedStatement p = (PreparedStatement) connection.prepareStatement(DELETE);

            p.setInt(1,id);

            p.executeUpdate();
            p.close();

            System.out.println("Blog message " + id + "was deleted");

        }catch ( SQLException e){
            throw new RuntimeException(e);
        }

    }

}
