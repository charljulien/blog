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
import java.util.List;

//Miss Gold ;)
@WebServlet("/Article")
public class BlogArticle extends HttpServlet {

        private static final String BLOG_ARTICLE ="/WEB-INF/theBlog/fullPages/blogArticle.jsp";
        private BlogPostServiceInterface blogPostService;


    @Override
    public void init() throws ServletException {
        blogPostService = (BlogPostService) getServletContext().getAttribute(AppContextListener.BLOG_SERVICE);
        if (blogPostService == null) {
            throw new ServletException("BlogPostService not available");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        long id = Long.parseLong(request.getParameter("id"));
        BlogPostBean blogPostById = blogPostService.readBlogPost(id);
        session.setAttribute("all",blogPostById);
        request.getRequestDispatcher(BLOG_ARTICLE).forward(request, response);
    }
}