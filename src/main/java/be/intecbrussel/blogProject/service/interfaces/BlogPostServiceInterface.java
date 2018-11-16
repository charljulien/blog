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

public interface BlogPostServiceInterface {

    /**
     * @see be.intecbrussel.blogProject.dao.BlogPostDAO#safeBlogPost(BlogPostBean)
     * */
    void saveBlogPostToDB(BlogPostBean blogPost, String userBean);

    /**
     * @see be.intecbrussel.blogProject.dao.BlogPostDAO#updateBlogPost(long, String)
     * */
    void updateBlogPostToDB(long id, String text);

    /**
     * @see be.intecbrussel.blogProject.dao.BlogPostDAO#deleteBlogPost(long)
     */
    void deleteBlogPostToDB(long id);
}
