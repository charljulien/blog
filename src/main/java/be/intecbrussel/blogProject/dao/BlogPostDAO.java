package be.intecbrussel.blogProject.dao;

import be.intecbrussel.blogProject.beans.BlogPostBean;

import com.mysql.jdbc.PreparedStatement;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.sql.Connection;
import java.sql.SQLException;

import be.intecbrussel.blogProject.beans.UserBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


/**
 * Represents the dataLayer of BlogPostBean class
 *
 * @author Mr. Black
 * @see be.intecbrussel.blogProject.beans.BlogPostBean
 */
public class BlogPostDAO {

    Connection connection = null;
    private static final String UPDATE = "UPDATE BlogPost SET blogMessage=?, likeBlogCounter=?, date=?, WHERE id=?";
    private static final String DELETE = "DELETE FROM BlogPost WHERE id=?";
    // Variables
    private EntityManager em;
    private EntityTransaction et;

    /**
     * Safes a Blog post
     *
     * @param blogPost by creation of new blogPost object
     * @see be.intecbrussel.blogProject.service.implementations.UserService#saveUserToDB(UserBean)
     */
    public void safeBlogPost(BlogPostBean blogPost) {
        System.out.println("Saving Blog Post DAO...");
        em = EMProvidor.getEntityManager();
        et = em.getTransaction();
        et.begin();
        em.persist(blogPost);
        et.commit();
    }

    /**
     * Update blog message in DB
     *
     * @param blogPost
     * @author Mr. Brown
     */

    //Update
    public void updateBlogPost(BlogPostBean blogPost) {
        System.out.println("Updating User DAO...");
        em = EMProvidor.getEntityManager();
        et = em.getTransaction();
//        try {
//            PreparedStatement p = (PreparedStatement) connection.prepareStatement(UPDATE);
//            p.setString(1, blogPost.getBlogMessage());
//
//            p.executeUpdate();
//            p.close();
//
//            System.out.println("Blog message " + blogPost.getId() + "was updated");
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    /**
     * Delete blog message in DB
     * Mr.Brown
     *
     * @param id
     */
    // Delete
    public void delete(int id) {
        try {
            PreparedStatement p = (PreparedStatement) connection.prepareStatement(DELETE);

            p.setInt(1, id);

            p.executeUpdate();
            p.close();

            System.out.println("Blog message " + id + "was deleted");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    // Queries      << NOT TESTED!! >>
    // find blog without link to user
    private TypedQuery<BlogPostBean> getBlogWithoutUserIdQuery() {
        TypedQuery<BlogPostBean> query = em.createQuery("SELECT blog FROM BlogPostBean AS blog where blog.user=:author", BlogPostBean.class);
        query.setParameter("author", null);
        return query;
    }

    public List<BlogPostBean> getBlowWithoutUserId() {
        return getBlogWithoutUserIdQuery().getResultList();
    }

    // Get blogs starting with recent date first
    private TypedQuery<BlogPostBean> getBlogsByRecentDateFirstQuery() {
        TypedQuery<BlogPostBean> query = em.createQuery("SELECT blog FROM BlogPostBean AS blog ORDER BY blog.date asc", BlogPostBean.class);
        return query;
    }

    public List<BlogPostBean> getBlogsByRecentDate() {
        return getBlogsByRecentDateFirstQuery().getResultList();
    }

    // Get blogs starting with oldest date first
    private TypedQuery<BlogPostBean> getBlogsByOldestDateFirstQuery() {
        TypedQuery<BlogPostBean> query = em.createQuery("SELECT blog FROM BlogPostBean AS blog ORDER BY blog.date desc", BlogPostBean.class);
        return query;
    }

    public List<BlogPostBean> getBlogsByOldestDateFirst() {
        return getBlogsByOldestDateFirstQuery().getResultList();
    }

    // Get blogs starting with most likes
    private TypedQuery<BlogPostBean> getBlogsWithMostLikesFirstQuery() {
        TypedQuery<BlogPostBean> query = em.createQuery("SELECT blog FROM BlogPostBean AS blog ORDER BY blog.likeBlogCounter asc", BlogPostBean.class);
        return query;
    }

    public List<BlogPostBean> getBlogsWithMostLikesFirst() {
        return getBlogsWithMostLikesFirstQuery().getResultList();
    }

    // Get blogs starting with less likes
    private TypedQuery<BlogPostBean> getBlogsWithLessLikesFirstQuery() {
        TypedQuery<BlogPostBean> query = em.createQuery("SELECT blog FROM BlogPostBean AS blog ORDER BY blog.likeBlogCounter desc", BlogPostBean.class);
        return query;
    }

    public List<BlogPostBean> getBlogsWithLessLikesFirst() {
        return getBlogsWithLessLikesFirstQuery().getResultList();
    }

    // Group blogs by Certain User
    private TypedQuery<BlogPostBean> getBlogsByPredefinedUserQuery(UserBean user) {
        TypedQuery<BlogPostBean> query = em.createQuery("SELECT blog FROM BlogPostBean AS blog WHERE blog.user.lastName=:name", BlogPostBean.class);
        query.setParameter("name", user.getLastName());
        return query;
    }

    public List<BlogPostBean> getBlogsByPredefinedUser(UserBean user) {
        return getBlogsByPredefinedUserQuery(user).getResultList();
    }

}
