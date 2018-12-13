package be.intecbrussel.blogProject.controller;

import be.intecbrussel.blogProject.service.implementations.BlogPostService;
import be.intecbrussel.blogProject.service.interfaces.BlogPostServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static be.intecbrussel.blogProject.controller.UserLoginServlet.getBlogByRecentDateAndAddToBlogCentralPage;
import static be.intecbrussel.blogProject.listeners.AppContextListener.BLOG_SERVICE;

/**
 * Loges a User out to the BlogSite
 *
 * @author Mr. Pink && Mr. Black
 * @see UserLoginServlet#getBlogByRecentDateAndAddToBlogCentralPage(HttpServletRequest, HttpServletResponse, BlogPostServiceInterface, String)
 * @see BlogPostService
 */
@WebServlet("/Logout")
public class UserLogoutServlet extends HttpServlet {

    private BlogPostServiceInterface blogPostService;
    private static final String BLOG_CENTRAL_PAGE = "WEB-INF/theBlog/fullPages/blogCentral.jsp";


    @Override
    public void init() throws ServletException {
        blogPostService = (BlogPostService) getServletContext().getAttribute(BLOG_SERVICE);
        if (blogPostService == null) {
            throw new ServletException("BlogPost Service not available");
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        getBlogByRecentDateAndAddToBlogCentralPage(request, response, blogPostService, BLOG_CENTRAL_PAGE);
    }
}
