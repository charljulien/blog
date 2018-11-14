package be.intecbrussel.blogProject.service.interfaces;

import be.intecbrussel.blogProject.beans.BlogPostBean;

public interface BlogPostServiceInterface {

    void saveBlogPostToDB(BlogPostBean blogpost);
}
