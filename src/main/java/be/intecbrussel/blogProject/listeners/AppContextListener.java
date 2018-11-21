package be.intecbrussel.blogProject.listeners;

import be.intecbrussel.blogProject.service.implementations.BlogPostService;
import be.intecbrussel.blogProject.service.implementations.CommentService;
import be.intecbrussel.blogProject.service.implementations.MemberAccessService;
import be.intecbrussel.blogProject.service.implementations.UserService;
import be.intecbrussel.blogProject.service.interfaces.BlogPostServiceInterface;
import be.intecbrussel.blogProject.service.interfaces.CommentServiceInterface;
import be.intecbrussel.blogProject.service.interfaces.MemberAccessServiceInterface;
import be.intecbrussel.blogProject.service.interfaces.UserServiceInterface;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author Mr. Black
 */
@WebListener
public class AppContextListener implements ServletContextListener {

    public static final String USER_SERVICE = "userService";
    public static final String ACCESS_SERVICE = "accessService";
    public static final String COMMENT_SERVICE = "commentService";
    public static final String BLOG_SERVICE = "blogService";


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("CONTEXT << THE BLOG >> INITIALIZED");

        UserServiceInterface userService = new UserService();
        MemberAccessServiceInterface accessService = new MemberAccessService();
        CommentServiceInterface commentService = new CommentService();
        BlogPostServiceInterface blogService = new BlogPostService();

        sce.getServletContext().setAttribute(USER_SERVICE, userService);
        sce.getServletContext().setAttribute(ACCESS_SERVICE, accessService);
        sce.getServletContext().setAttribute(COMMENT_SERVICE, commentService);
        sce.getServletContext().setAttribute(BLOG_SERVICE, blogService);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("CONTEXT DESTROYED");
    }


}
