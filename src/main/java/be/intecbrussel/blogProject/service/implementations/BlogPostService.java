package be.intecbrussel.blogProject.service.implementations;

import be.intecbrussel.blogProject.beans.BlogPostBean;
import be.intecbrussel.blogProject.dao.BlogPostDAO;
import be.intecbrussel.blogProject.service.interfaces.BlogPostServiceInterface;

public class BlogPostService implements BlogPostServiceInterface {

    // Variables
    private BlogPostDAO blogPostDAO;

    // Constructor
    public BlogPostService(){
        blogPostDAO = new BlogPostDAO();
    }

    @Override
    public void saveBlogPostToDB(BlogPostBean blogpost) {
        System.out.println("Saving Blog Post to DB SERVICE...");
        blogPostDAO.safeBlogPost(blogpost);
    }
}
