package be.intecbrussel.blogProject.service.interfaces;
/**
 * BlogPost Interface for BlogPostBean class
 *
 * @author Mr. Black
 * @see be.intecbrussel.blogProject.beans.BlogPostBean
 * @see be.intecbrussel.blogProject.dao.BlogPostDAO
 */

import be.intecbrussel.blogProject.beans.BlogPostBean;
import be.intecbrussel.blogProject.beans.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface BlogPostServiceInterface {

    /**
     * Sort object by date old to new
     */
    void sortBlogPostsOldToNew();

    /**
     * Sort object by date new to old
     */
    void sortBlogPostsNewToOld();

    /**
     * This is the BETA version
     *
     * @see be.intecbrussel.blogProject.dao.BlogPostDAO#saveBlogPost(BlogPostBean)
     */
    void saveBlogPostToDB(BlogPostBean blogPost, String userBean);

    /**
     * This Method will be used in Servlet BlogPostServlet to add a BlogPost and Connected with the logged-in User
     *
     * @see be.intecbrussel.blogProject.controller.BlogPostServlet#doPost(HttpServletRequest, HttpServletResponse)
     * @see be.intecbrussel.blogProject.dao.BlogPostDAO#saveBlogPost(BlogPostBean)
     * @see be.intecbrussel.blogProject.service.implementations.BlogPostService#saveBlogPostToDB(BlogPostBean, UserBean)
     */
    void saveBlogPostToDB(BlogPostBean blogPost, UserBean userBean);

    /**
     * @see be.intecbrussel.blogProject.dao.BlogPostDAO#updateBlogPost(long, String)
     */
    void updateBlogPostToDB(long id, String text);

    /**
     * @see be.intecbrussel.blogProject.dao.BlogPostDAO#deleteBlogPost(long)
     */
    void deleteBlogPostToDB(long id);

    // TEST FASE did not work till now, second one works via intellij
    void likeBlogPostCountIncrease(BlogPostBean blog);

    /**
     * BETA TESTER TO ADD A LIKE TO A POST
     * THIS METHOD WORKS VIA INTELLIJ BETA2TESTER
     *
     * @author Mr. Black
     */
    void likeBlogPostCountIncrease(long id);

    /**
     * Reads a Blog post
     *
     * @param title String of the BlogPostBean
     * @return BlogPostBean object with predefined title String
     * @author Mr. Black
     * @see be.intecbrussel.blogProject.dao.BlogPostDAO#readBlogPost(String)
     * @see be.intecbrussel.blogProject.service.implementations.BlogPostService#readBlogPost(String)
     */
    BlogPostBean readBlogPost(String title);

    List<BlogPostBean> readBlogPostByRecentDate();

}
