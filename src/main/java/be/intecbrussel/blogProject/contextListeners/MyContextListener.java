<<<<<<< HEAD
package be.intecbrussel.blogProject.contextListeners;

import be.intecbrussel.blogProject.exceptions.InvalidContextAttributeException;
import be.intecbrussel.blogProject.service.implementations.BlogPostService;
import be.intecbrussel.blogProject.service.interfaces.BlogPostServiceInterface;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.io.IOException;

@WebListener
public class MyContextListener implements HttpSessionListener, ServletContextListener {
    BlogPostServiceInterface blogPostService;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent)  {
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();

        try {
            Object object = servletContext.getAttribute("blogPostService");
            if ( object instanceof BlogPostServiceInterface){
                blogPostService = (BlogPostService) servletContext.getAttribute("blogPostService");
            }
            else {
                throw new InvalidContextAttributeException("This attribute does not exist.");
            }

        }catch (InvalidContextAttributeException icae){

        }

        servletContext.setAttribute("blogPostService", blogPostService);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {


    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
//        servletContextEvent.setAttribute("commentService");
//        servletContextEvent.setAttribute("blogPostService");
//        servletContextEvent.

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
=======
//package be.intecbrussel.blogProject.contextListeners;
//
//import be.intecbrussel.blogProject.exceptions.InvalidContextAttributeException;
//import be.intecbrussel.blogProject.service.implementations.BlogPostService;
//import be.intecbrussel.blogProject.service.interfaces.BlogPostServiceInterface;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//import javax.servlet.http.HttpSessionEvent;
//import javax.servlet.http.HttpSessionListener;
//import java.io.IOException;
//
//@WebListener
//public class MyContextListener implements HttpSessionListener, ServletContextListener {
//    BlogPostServiceInterface blogPostService;
//
//    @Override
//    public void sessionCreated(HttpSessionEvent httpSessionEvent)  {
//        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
//
//        try {
//            Object object = servletContext.getAttribute("blogPostService");
//            if ( object instanceof BlogPostServiceInterface){
//                blogPostService = (BlogPostService) servletContext.getAttribute("blogPostService");
//            }
//            else {
//                throw new InvalidContextAttributeException("This attribute does not exist.");
//            }
//
//        }catch (InvalidContextAttributeException icae){
//
//        }
//
//        servletContext.setAttribute("blogPostService", blogPostService);
//    }
//
//    @Override
//    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
//
//
//    }
//
//    @Override
//    public void contextInitialized(ServletContextEvent servletContextEvent) {
//        servletContextEvent.setAttribute("commentService");
//        servletContextEvent.setAttribute("blogPostService");
//        servletContextEvent.
//
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent servletContextEvent) {
//
//    }
//}
>>>>>>> 41a138b9fa3e1ff249a84853b46114d8c1065e68
