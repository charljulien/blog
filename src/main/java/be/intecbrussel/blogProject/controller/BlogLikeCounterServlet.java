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
import java.io.IOException;

/**
 * Adds likes to a certain BlogPostBean
 *
 * @author Mr. Black
 * @see BlogPostService#readBlogPost(String)
 * @see BlogPostService#likeBlogPostCountIncrease(BlogPostBean)
 */
@WebServlet("/Like")
public class BlogLikeCounterServlet extends HttpServlet {

    private BlogPostServiceInterface blogPostService;
    private static final String BLOG_ID = "blogId";
    private static final String BLOG_POST_PAGE = "/WEB-INF/theBlog/fullPages/blogArticle.jsp";


    @Override
    public void init() throws ServletException {
        blogPostService = (BlogPostService) getServletContext().getAttribute(AppContextListener.BLOG_SERVICE);
        if (blogPostService == null) {
            throw new ServletException("BlogPostService not available");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher(BLOG_POST_PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        BlogPostBean blog = blogPostService.readBlogPost(Long.parseLong(request.getParameter(BLOG_ID)));
        blogPostService.likeBlogPostCountIncrease(blog);
        response.sendRedirect("./Article?id=" + Long.parseLong(request.getParameter(BLOG_ID)));
    }

}
