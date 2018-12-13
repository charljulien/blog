package be.intecbrussel.blogProject.controller;

import be.intecbrussel.blogProject.beans.BlogPostBean;
import be.intecbrussel.blogProject.listeners.AppContextListener;
import be.intecbrussel.blogProject.service.implementations.BlogPostService;
import be.intecbrussel.blogProject.service.interfaces.BlogPostServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Shows A full BlogArticle, StandAlone Blog of a certain User
 *
 * @author Mr. Black
 * @see BlogPostService#readBlogPost(long)
 * @see BlogPostBean
 */
@WebServlet("/Article")
public class BlogArticle extends HttpServlet {

    private BlogPostServiceInterface blogPostService;
    static final String BLOG = "blogArticle";
    private static final String BLOG_ARTICLE = "/WEB-INF/theBlog/fullPages/blogArticle.jsp";


    @Override
    public void init() throws ServletException {
        blogPostService = (BlogPostService) getServletContext().getAttribute(AppContextListener.BLOG_SERVICE);
        if (blogPostService == null) {
            throw new ServletException("BlogPostService not available");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        long id = Long.parseLong(request.getParameter("id"));
        BlogPostBean blogPostById = blogPostService.readBlogPost(id);
        // below deleted session changed request

        request.setAttribute(BLOG, blogPostById);
        request.getRequestDispatcher(BLOG_ARTICLE).forward(request, response);
    }

}