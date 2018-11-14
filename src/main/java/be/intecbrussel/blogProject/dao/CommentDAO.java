package be.intecbrussel.blogProject.dao;

import be.intecbrussel.blogProject.beans.CommentBean;
import com.mysql.jdbc.PreparedStatement;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Represents dataLayer of CommentBean class
 *
 * @author Mr. Black
 * @see CommentBean
 * @see be.intecbrussel.blogProject.service.interfaces.CommentServiceInterface
 */
public class CommentDAO {

    Connection connection=null;
    private static final String UPDATE = "UPDATE comments SET comment=?, date=?, WHERE id=?";
    private static final String DELETE = "DELETE FROM comments WHERE id=?";


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

    /**
     * Delete comment in DB
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

            System.out.println("Comment " + id + "was deleted");

        }catch ( SQLException e){
            throw new RuntimeException(e);
        }

    }

}
