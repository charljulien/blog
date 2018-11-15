package be.intecbrussel.blogProject.service.implementations;

import be.intecbrussel.blogProject.beans.BlogPostBean;
import be.intecbrussel.blogProject.dao.BlogPostDAO;
import be.intecbrussel.blogProject.service.interfaces.BlogPostServiceInterface;

/**
 * Represents the serviceLayer of BlogPostBean class
 *
 * @author Mr. Black
 * @see BlogPostBean
 * @see BlogPostDAO
 */
public class BlogPostService implements BlogPostServiceInterface {


    private BlogPostDAO blogPostDAO;


    public BlogPostService() {
        blogPostDAO = new BlogPostDAO();
    }


    /**
     * Saves a BlogPost to the DB
     *
     * @param blogPost object
     * @author Mr. Black
     */
    @Override
    public void saveBlogPostToDB(BlogPostBean blogPost) {
        System.out.println("Saving Blog Post to DB SERVICE...");
        blogPostDAO.safeBlogPost(blogPost);
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
}
