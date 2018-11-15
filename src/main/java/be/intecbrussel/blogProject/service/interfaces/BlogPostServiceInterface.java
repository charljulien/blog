package be.intecbrussel.blogProject.service.interfaces;
/**
 * BlogPost Interface for BlogPostBean class
 *
 * @author Mr. Black
 * @see be.intecbrussel.blogProject.beans.BlogPostBean
 * @see be.intecbrussel.blogProject.dao.BlogPostDAO
 */
import be.intecbrussel.blogProject.beans.BlogPostBean;

public interface BlogPostServiceInterface {

    void saveBlogPostToDB(BlogPostBean blogpost);
}
