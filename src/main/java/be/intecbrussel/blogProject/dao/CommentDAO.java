package be.intecbrussel.blogProject.dao;

import be.intecbrussel.blogProject.beans.CommentBean;

import com.mysql.jdbc.PreparedStatement;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import javax.persistence.TypedQuery;
import java.util.List;


/**
 * Represents dataLayer of CommentBean class
 *
 * @author Mr. Black
 * @see CommentBean
 * @see be.intecbrussel.blogProject.service.interfaces.CommentServiceInterface
 */
public class CommentDAO {

    private static final String UPDATE = "UPDATE comments SET comment=?, date=?, WHERE id=?";
    private static final String DELETE = "DELETE FROM comments WHERE id=?";


    // Variables
    private EntityManager em;
    private EntityTransaction et;


    /**
     * Saves a comment to the DB
     *
     * @param comment object
     * @author Mr. Black
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
     *
     * @param id of object comment to delete
     * @author Mr.Black
     */
    public void deleteComment(long id) {
        System.out.println("Deleting Comment DAO...");
        em = EMProvidor.getEntityManager();
        et = em.getTransaction();
        et.begin();
        List<CommentBean> commentList = getCommentById(id);
        for (CommentBean comment : commentList) {
            em.remove(comment);
        }
        et.commit();
    }


    /**
     * Query to find certain comment by lastName
     *
     * @param lastName of object UserBean
     * @return comments based on certain lastName
     * @author Mr. Black
     */
    private TypedQuery<CommentBean> getCommentsByNameQuery(String lastName) {
        TypedQuery<CommentBean> query = em.createQuery("SELECT comment FROM CommentBean AS comment WHERE comment.userComment.lastName=:name", CommentBean.class);
        query.setParameter("name", lastName);
        return query;
    }

    public List<CommentBean> getCommentsByName(String lastName) {
        return getCommentsByNameQuery(lastName).getResultList();
    }

    /**
     * Query to find certain comment by id
     *
     * @param id of the object comment
     * @return an id query of comment
     * @author Mr. Black
     */
    private TypedQuery<CommentBean> getCommentByIdQuery(long id) {
        TypedQuery<CommentBean> query = em.createQuery("SELECT comment FROM CommentBean AS comment WHERE comment.id=:id", CommentBean.class);
        query.setParameter("id", id);
        return query;
    }

    public List<CommentBean> getCommentById(long id) {
        return getCommentByIdQuery(id).getResultList();
    }

}
