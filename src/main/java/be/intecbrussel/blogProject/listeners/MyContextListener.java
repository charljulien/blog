package be.intecbrussel.blogProject.listeners;

import be.intecbrussel.blogProject.service.implementations.BlogPostService;
import be.intecbrussel.blogProject.service.implementations.CommentService;
import be.intecbrussel.blogProject.service.implementations.MemberAccessService;
import be.intecbrussel.blogProject.service.implementations.UserService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener {

    /**
     * Method responsible for starting a new service of each type upon initialization of context ( aka startup of your UI, in this case it being our web app ).
     *
     * @author Miss Gold
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().setAttribute("commentService", new CommentService());
        servletContextEvent.getServletContext().setAttribute("blogPostService", new BlogPostService());
        servletContextEvent.getServletContext().setAttribute("userService", new UserService());
        servletContextEvent.getServletContext().setAttribute("memberAccessService", new MemberAccessService());
    }

    /**
     * Method responsible for destroying all the services created upon initialization of context ( so when you x/close your app UI, services go away).
     * No implementation necessary, right?
     * @author Miss Gold
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {


    }
}
