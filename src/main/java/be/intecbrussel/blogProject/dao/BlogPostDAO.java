package be.intecbrussel.blogProject.dao;

import be.intecbrussel.blogProject.beans.BlogPostBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import be.intecbrussel.blogProject.beans.UserBean;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Represents the dataLayer of BlogPostBean class
 *
 * @author Mr. Black
 * @see be.intecbrussel.blogProject.beans.BlogPostBean
 * @see be.intecbrussel.blogProject.service.interfaces.BlogPostServiceInterface
 */
public class BlogPostDAO {

    private EntityManager em;
    private EntityTransaction et;

    /**
     * Safes a Blog post
     *
     * @param blogPost by creation of new blogPost object
     * @author Mr. Black
     * @see be.intecbrussel.blogProject.service.implementations.UserService#saveUserToDB(UserBean)
     */
    public void saveBlogPost(BlogPostBean blogPost) {
        System.out.println("Saving Blog Post DAO...");
        em = EMProvidor.getEntityManager();
        et = em.getTransaction();
        et.begin();
        em.merge(blogPost);
        et.commit();
        EMProvidor.getInstance().closeEmf();
    }

    /**
     * Update blog message
     *
     * @param id   of the object BlogPost to update
     * @param text to concatenate original text
     * @author Mr. Black
     * @see be.intecbrussel.blogProject.service.implementations.BlogPostService#updateBlogPostToDB(long, String)
     */
    public void updateBlogPost(long id, String text) {
        System.out.println("Updating BlogPost DAO...");
        em = EMProvidor.getEntityManager();
        et = em.getTransaction();
        et.begin();
        List<BlogPostBean> blogPost = getBlogWithPredefinedId(id);
        for (BlogPostBean post : blogPost) {
            post.setBlogMessage(post.getBlogMessage() + " " + text);
            em.merge(post);
        }
        et.commit();
        EMProvidor.getInstance().closeEmf();
    }

    /**
     * Delete blog message in DB
     *
     * @param id of object BlogPost
     * @author Mr. Black
     * @see be.intecbrussel.blogProject.service.implementations.BlogPostService#deleteBlogPostToDB(long)
     */
    public void deleteBlogPost(long id) {
        System.out.println("Deleting BlogPost DAO...");
        em = EMProvidor.getEntityManager();
        et = em.getTransaction();
        et.begin();
        List<BlogPostBean> blogPost = getBlogWithPredefinedId(id);
        for (BlogPostBean blog : blogPost) {
            em.remove(blog);
        }
        et.commit();
        EMProvidor.getInstance().closeEmf();
    }

    /**
     * Query to find Blog without an UserId
     *
     * @author Mr. Black
     * @see BlogPostDAO#getBlowWithoutUserId()
     */
    private TypedQuery<BlogPostBean> getBlogWithoutUserIdQuery() {
        em = EMProvidor.getEntityManager();
        TypedQuery<BlogPostBean> query = em.createQuery("SELECT blog FROM BlogPostBean AS blog WHERE blog.user=:author", BlogPostBean.class);
        query.setParameter("author", null);
        return query;
    }

    public List<BlogPostBean> getBlowWithoutUserId() {
        return getBlogWithoutUserIdQuery().getResultList();
    }

    /**
     * Query to find Blog with certain Id
     *
     * @param id of object BlogPost
     * @author Mr. Black
     * @see BlogPostDAO#getBlogWithPredefinedId(long)
     */
    private TypedQuery<BlogPostBean> getBlogWithPredefinedIdQuery(long id) {
        em = EMProvidor.getEntityManager();
        TypedQuery<BlogPostBean> query = em.createQuery("SELECT blog FROM BlogPostBean AS blog WHERE blog.id=:id", BlogPostBean.class);
        query.setParameter("id", id);
        return query;
    }

    public List<BlogPostBean> getBlogWithPredefinedId(long id) {
        return getBlogWithPredefinedIdQuery(id).getResultList();
    }

    /**
     * Query to find Blog sorted by recent date first
     *
     * @author Mr. Black
     * @see BlogPostDAO#getBlogsByRecentDate()
     */
    private TypedQuery<BlogPostBean> getBlogsByRecentDateFirstQuery() {
        em = EMProvidor.getEntityManager();
        TypedQuery<BlogPostBean> query = em.createQuery("SELECT blog FROM BlogPostBean AS blog ORDER BY blog.date asc", BlogPostBean.class);
        return query;
    }

    public List<BlogPostBean> getBlogsByRecentDate() {
        return getBlogsByRecentDateFirstQuery().getResultList();
    }

    /**
     * Query to find Blog sorted by oldest date first
     *
     * @author Mr. Black
     * @see BlogPostDAO#getBlogsByOldestDateFirst()
     */
    private TypedQuery<BlogPostBean> getBlogsByOldestDateFirstQuery() {
        em = EMProvidor.getEntityManager();
        TypedQuery<BlogPostBean> query = em.createQuery("SELECT blog FROM BlogPostBean AS blog ORDER BY blog.date desc", BlogPostBean.class);
        return query;
    }

    public List<BlogPostBean> getBlogsByOldestDateFirst() {
        return getBlogsByOldestDateFirstQuery().getResultList();
    }

    /**
     * Query to find Blog sorted with most likes first
     *
     * @author Mr. Black
     * @see BlogPostDAO#getBlogsWithMostLikesFirst()
     */
    private TypedQuery<BlogPostBean> getBlogsWithMostLikesFirstQuery() {
        em = EMProvidor.getEntityManager();
        TypedQuery<BlogPostBean> query = em.createQuery("SELECT blog FROM BlogPostBean AS blog ORDER BY blog.likeBlogCounter asc", BlogPostBean.class);
        return query;
    }

    public List<BlogPostBean> getBlogsWithMostLikesFirst() {
        return getBlogsWithMostLikesFirstQuery().getResultList();
    }

    /**
     * Query to find Blog sorted with least likes first
     *
     * @author Mr. Black
     * @see BlogPostDAO#getBlogsWithLessLikesFirst()
     */
    private TypedQuery<BlogPostBean> getBlogsWithLessLikesFirstQuery() {
        em = EMProvidor.getEntityManager();
        TypedQuery<BlogPostBean> query = em.createQuery("SELECT blog FROM BlogPostBean AS blog ORDER BY blog.likeBlogCounter desc", BlogPostBean.class);
        return query;
    }

    public List<BlogPostBean> getBlogsWithLessLikesFirst() {
        return getBlogsWithLessLikesFirstQuery().getResultList();
    }

    /**
     * Query to group Blogs by a certain User
     *
     * @param user String to find the lastName of User in BlogPost
     * @author Mr. Black
     * @see BlogPostDAO#getBlogsByPredefinedUser(String)
     */
    private TypedQuery<BlogPostBean> getBlogsByPredefinedUserQuery(String user) {
        em = EMProvidor.getEntityManager();
        TypedQuery<BlogPostBean> query = em.createQuery("SELECT blog FROM BlogPostBean AS blog WHERE blog.user.lastName=:name", BlogPostBean.class);
        query.setParameter("name", user);
        return query;
    }

    public List<BlogPostBean> getBlogsByPredefinedUser(String user) {
        return getBlogsByPredefinedUserQuery(user).getResultList();
    }

}
