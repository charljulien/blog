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
     * Saves a BlogPost to the DB
     *
     * @param blogPost object
     * @author Mr. Black
     */
    @Override
    public void saveBlogPostToDB(BlogPostBean blogPost,String lastName) {
        System.out.println("Saving Blog Post to DB SERVICE...");
<<<<<<< HEAD
        List<UserBean> userLastName = userDAO.getUserByLastName(lastName);
        for(UserBean user : userLastName){
            blogPost.setUser(user);
        }
        blogPostDAO.safeBlogPost(blogPost);

=======
        blogPostDAO.saveBlogPost(blogPost);
>>>>>>> 014215b2329a0e7613036ede9507c3208005d037
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
