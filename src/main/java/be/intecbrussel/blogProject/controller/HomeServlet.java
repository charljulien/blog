package be.intecbrussel.blogProject.controller;

import be.intecbrussel.blogProject.listeners.AppContextListener;
import be.intecbrussel.blogProject.service.implementations.BlogPostService;
import be.intecbrussel.blogProject.service.interfaces.BlogPostServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static be.intecbrussel.blogProject.controller.UserLoginServlet.getBlogByRecentDateAndAddToBlogCentralPage;

/**
 * Show the HomePage == Home Central page limited to six BlogPosts
 *
 * @see UserLoginServlet#getBlogByRecentDateAndAddToBlogCentralPage(HttpServletRequest, HttpServletResponse, BlogPostServiceInterface, String)
 * @see BlogPostService
 * Mr. Black && Mr. Pink
 */
@WebServlet("/Home")
public class HomeServlet extends HttpServlet {

    private BlogPostServiceInterface blogPostService;
    private static final String BLOG_CENTRAL_PAGE = "WEB-INF/theBlog/fullPages/blogCentral.jsp";


    @Override
    public void init() throws ServletException {
        blogPostService = (BlogPostService) getServletContext().getAttribute(AppContextListener.BLOG_SERVICE);
        if (blogPostService == null) {
            throw new ServletException("BlogPostService not available");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getBlogByRecentDateAndAddToBlogCentralPage(request, response, blogPostService, BLOG_CENTRAL_PAGE);
    }

}
