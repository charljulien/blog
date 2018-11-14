package be.intecbrussel.blogProject.dao;

import be.intecbrussel.blogProject.beans.CommentBean;
<<<<<<< HEAD
import com.mysql.jdbc.PreparedStatement;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.sql.Connection;
import java.sql.SQLException;
=======
import be.intecbrussel.blogProject.beans.UserBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
>>>>>>> 647e11ec528a76a5e45f0c517ae0c283527c0771

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

    // Queries << NOT TESTED!! >>
    // Find comments by name
    private TypedQuery<CommentBean> getCommentsByNameQuery(UserBean user) {
        TypedQuery<CommentBean> query = em.createQuery("SELECT comment FROM CommentBean as comment where comment.userComment.lastName=:name", CommentBean.class);
        query.setParameter("name", user.getLastName());
        return query;
    }

    public List<CommentBean> getCommentsByName(UserBean user) {
        return getCommentsByNameQuery(user).getResultList();
    }

}
