package be.intecbrussel.blogProject.controller;

import be.intecbrussel.blogProject.beans.BlogPostBean;
import be.intecbrussel.blogProject.dao.BlogPostDAO;
import be.intecbrussel.blogProject.listeners.AppContextListener;
import be.intecbrussel.blogProject.service.implementations.BlogPostService;
import be.intecbrussel.blogProject.service.implementations.UserService;
import be.intecbrussel.blogProject.service.interfaces.BlogPostServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static be.intecbrussel.blogProject.controller.HomeServlet.ALL;
import static be.intecbrussel.blogProject.listeners.AppContextListener.BLOG_SERVICE;

/**
 * Class creates Servlet logout for JSP pages
 *
 * @author Mr. Pink && Mr. Black
 */
@WebServlet("/Logout")
public class UserLogoutServlet extends HttpServlet {

    private static final String BLOG_CENTRAL_PAGE = "WEB-INF/theBlog/fullPages/blogCentral.jsp";
    private BlogPostServiceInterface blogPostService;

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
        List<BlogPostBean> all = blogPostService.readBlogPostByRecentDate();
        System.out.println(all);
        request.setAttribute(ALL, all);
        request.getRequestDispatcher(BLOG_CENTRAL_PAGE).forward(request, response);

    }
}
