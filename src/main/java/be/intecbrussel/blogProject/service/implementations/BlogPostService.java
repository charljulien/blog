package be.intecbrussel.blogProject.service.implementations;

import be.intecbrussel.blogProject.beans.BlogPostBean;
import be.intecbrussel.blogProject.beans.UserBean;
import be.intecbrussel.blogProject.dao.BlogPostDAO;
import be.intecbrussel.blogProject.dao.UserDAO;
import be.intecbrussel.blogProject.service.interfaces.BlogPostServiceInterface;

import java.util.List;

/**
 * Represents the serviceLayer of BlogPostBean class
 *
 * @author Mr. Black
 * @see BlogPostBean
 * @see BlogPostDAO
 */
public class BlogPostService implements BlogPostServiceInterface {
    private BlogPostDAO blogPostDAO;
    private UserDAO userDAO;

    public BlogPostService() {
        blogPostDAO = new BlogPostDAO();
        userDAO = new UserDAO();
    }

    /**
     * Sort object by date old to new
     */
    @Override
    public void sortBlogPostsOldToNew() {
        blogPostDAO.getBlogsByOldestDateFirst();
    }

    /**
     * Sort object by date new to old
     */
    @Override
    public void sortBlogPostsNewToOld() {

    }

    /**
     * Saves a BlogPost to the DB
     * This is the BETA version
     *
     * @param blogPost object
     * @author Mr. Black
     */
    @Override
    public void saveBlogPostToDB(BlogPostBean blogPost, String lastName) {
        System.out.println("Saving Blog Post to DB SERVICE...");
        List<UserBean> userLastName = userDAO.getUserByLastName(lastName);
        for (UserBean user : userLastName) {
            blogPost.setUser(user);
        }
        blogPostDAO.saveBlogPost(blogPost);
    }

    /**
     * Saves a BlogPost to the DB via servlet
     *
     * @param blogPost object
     * @param user     object, obtained by session.getAttribute(USER_BEAN)
     * @author Mr. Black
     */
    //M Gold : VIA servlet?? where is the servlet in all of this?
    @Override
    public void saveBlogPostToDB(BlogPostBean blogPost, UserBean user) {
        System.out.println("Saving Blog Post to DB SERVICE...");
        System.out.println("Logged in user: " + user.toString());
        System.out.println("Blog Posted by Logged in user: " + blogPost);

        blogPost.setUser(user);
        blogPostDAO.saveBlogPost(blogPost);
    }

    /**
     * Updates attribute message of a predefined blogPost
     *
     * @param id   of the object BlogPost to update
     * @param text to concatenate original text
     * @author Mr. Black
     */
    @Override
    public void updateBlogPostToDB(long id, String text) {
        System.out.println("Updating Blog Post to DB SERVICE...");
        blogPostDAO.updateBlogPost(id, text);
    }

    /**
     * Deletes an object BlogPost with predefined id
     *
     * @param id of the object BlogPost to delete
     * @author Mr. Black
     */
    @Override
    public void deleteBlogPostToDB(long id) {
        System.out.println("Deleting Blog Post from DB SERVICE...");
        blogPostDAO.deleteBlogPost(id);
    }

    /**
     * Adds a like to the blogCounter
     * THESE TWO ARE BETA'S  -- SECOND ONE WORKS
     *
     * @author Mr. Black
     */
    @Override
    public void likeBlogPostCountIncrease(BlogPostBean blog) {
        System.out.println("Liking Blog count +1 SERVICE...");
        blogPostDAO.likeBlogPostCountIncrease(blog);
    }

    /**
     * BETA TESTER TO ADD A LIKE TO A POST
     * THIS METHOD WORKS VIA INTELLIJ BETA2TESTER
     *
     * @author Mr. Black
     */
    @Override
    public void likeBlogPostCountIncrease(long id) {
        System.out.println("Liking Blog count +1 SERVICE...");
        blogPostDAO.likeBlogPostCountIncrease(id);
    }

    /**
     * Reads a Blog post
     *
     * @param title String of the BlogPostBean
     * @return BlogPostBean object with predefined title String
     * @author Mr. Black
     * @see be.intecbrussel.blogProject.dao.BlogPostDAO#readBlogPost(String)
     */
    @Override
    public BlogPostBean readBlogPost(String title) {
        System.out.println("Reading from the DB SERVICE...");
        return blogPostDAO.readBlogPost(title);
    }

    @Override
    public List<BlogPostBean> readBlogPostByRecentDate() {
        return blogPostDAO.getBlogsByRecentDate();
    }

    @Override
    public BlogPostBean readBlogPost(long id) {
        return blogPostDAO.readBlogPost(id);
    }
}
