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
     * Saves a Blog post
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
     * Reads a Blog post
     *
     * @param title String of the BlogPostBean
     * @return BlogPostBean object with predefined title String
     * @authr Mr. Black
     */
    public BlogPostBean readBlogPost(String title) {
        System.out.println("Connecting to read from DB...");
        em = EMProvidor.getEntityManager();
        BlogPostBean idUser = getBlogWithPredefinedTitle(title);
        //   System.out.println(idUser);
        return idUser;
    }

    public List<BlogPostBean> readBlogPost() {
        System.out.println("Connecting to read from DB...");
        em = EMProvidor.getEntityManager();
        List<BlogPostBean> blogs = getAllBlogs();
        //   System.out.println(idUser);
        return blogs;
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
        List<BlogPostBean> blogPost = getListBlogWithPredefinedId(id);
        for (BlogPostBean post : blogPost) {
            post.setBlogMessage(post.getBlogMessage() + " " + text);
            em.merge(post);
        }
        et.commit();
        EMProvidor.getInstance().closeEM();
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
        List<BlogPostBean> blogPost = getListBlogWithPredefinedId(id);
        for (BlogPostBean blog : blogPost) {
            em.remove(blog);
        }
        et.commit();
        EMProvidor.getInstance().closeEmf();
    }

    // TEST FASE did not work till now, second one works via intellij
    public void likeBlogPostCountIncrease(BlogPostBean blog) {
        System.out.println("Liking Blog count +1 DAO...");
        em = EMProvidor.getEntityManager();
        et = em.getTransaction();
        et.begin();
         blog.likeIncrease();
        em.merge(blog);
        et.commit();
        EMProvidor.getInstance().closeEM();
    }

    /**
     * BETA TESTER TO ADD A LIKE TO A POST
     * THIS METHOD WORKS VIA INTELLIJ BETA2TESTER
     *
     * @author Mr. Black
     */
    //Miss Gold: but not when used in browser?? how to fix?
    public void likeBlogPostCountIncrease(long id) {
        System.out.println("Liking Blog count +1 DAO...");
        em = EMProvidor.getEntityManager();
        BlogPostBean blogWithPredefinedId = getBlogWithPredefinedId(id);
        blogWithPredefinedId.likeIncrease();
        em.persist(blogWithPredefinedId);
        et = em.getTransaction();
        et.begin();
        et.commit();
        EMProvidor.getInstance().closeEM();
    }


    /**
     * Query to find all Blogs
     *
     * @author Mr. Black
     * @see BlogPostDAO#getAllBlogs()
     */
    private TypedQuery<BlogPostBean> getAllBlogsQuery() {
        em = EMProvidor.getEntityManager();
        TypedQuery<BlogPostBean> query = em.createQuery("SELECT blog FROM BlogPostBean AS blog", BlogPostBean.class);
        return query;
    }

    public List<BlogPostBean> getAllBlogs() {
        return getAllBlogsQuery().getResultList();
    }

    /**
     * Query to find Blog without an UserId
     *
     * @author Mr. Black
     * @see BlogPostDAO#getBlogWithoutUserId()
     */
    private TypedQuery<BlogPostBean> getBlogWithoutUserIdQuery() {
        em = EMProvidor.getEntityManager();
        TypedQuery<BlogPostBean> query = em.createQuery("SELECT blog FROM BlogPostBean AS blog WHERE blog.user=:author", BlogPostBean.class);
        query.setParameter("author", null);
        return query;
    }

    public List<BlogPostBean> getBlogWithoutUserId() {
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

    public List<BlogPostBean> getListBlogWithPredefinedId(long id) {
        return getBlogWithPredefinedIdQuery(id).getResultList();
    }

    public BlogPostBean getBlogWithPredefinedId(long id) {
        return getBlogWithPredefinedIdQuery(id).getSingleResult();
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

    /**
     * Query to find BlogPostBean with predefined title
     *
     * @param title String to find the BlogPostBean Object
     * @author Mr. Black
     * @see BlogPostDAO#getBlogWithPredefinedTitle(String)
     */
    private TypedQuery<BlogPostBean> getBlogWithPredefinedTitleQuery(String title) {
        em = EMProvidor.getEntityManager();
        TypedQuery<BlogPostBean> query = em.createQuery("SELECT blog FROM BlogPostBean AS blog where blog.title=:title", BlogPostBean.class);
        query.setParameter("title", title);
        return query;
    }

    public BlogPostBean getBlogWithPredefinedTitle(String title) {
        return getBlogWithPredefinedTitleQuery(title).getSingleResult();
    }

}
