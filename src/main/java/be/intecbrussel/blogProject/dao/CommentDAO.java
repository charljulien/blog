package be.intecbrussel.blogProject.dao;

import be.intecbrussel.blogProject.beans.CommentBean;

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
        em.merge(comment);
        et.commit();
        EMProvidor.getInstance().closeEmf();
    }

    public List<CommentBean> readAllComments() {
        System.out.println("Reading all Comments DAO...");
        em = EMProvidor.getEntityManager();
        return getAllComments();
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
        EMProvidor.getInstance().closeEmf();
    }


    /**
     * Query to find certain comment by lastName
     *
     * @param lastName of object UserBean
     * @return comments based on certain lastName
     * @author Mr. Black
     * @see CommentDAO#getCommentsByName(String)
     */
    private TypedQuery<CommentBean> getCommentsByNameQuery(String lastName) {
        em = EMProvidor.getEntityManager();
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
     * @see CommentDAO#getCommentById(long)
     */
    private TypedQuery<CommentBean> getCommentByIdQuery(long id) {
        em = EMProvidor.getEntityManager();
        TypedQuery<CommentBean> query = em.createQuery("SELECT comment FROM CommentBean AS comment WHERE comment.id=:id", CommentBean.class);
        query.setParameter("id", id);
        return query;
    }

    public List<CommentBean> getCommentById(long id) {
        return getCommentByIdQuery(id).getResultList();
    }


    /**
     * Query to find all Comments
     */
    private TypedQuery<CommentBean> getAllCommentsQuery() {
        em = EMProvidor.getEntityManager();
        TypedQuery<CommentBean> query = em.createQuery("SELECT comment FROM CommentBean As comment WHERE comment.userComment.blogs", CommentBean.class);
        return query;
    }

    public List<CommentBean> getAllComments() {
        return getAllCommentsQuery().getResultList();
    }


}
