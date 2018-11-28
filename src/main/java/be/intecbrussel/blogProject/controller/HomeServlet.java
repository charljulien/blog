package be.intecbrussel.blogProject.controller;

import be.intecbrussel.blogProject.beans.BlogPostBean;
import be.intecbrussel.blogProject.dao.BlogPostDAO;
import be.intecbrussel.blogProject.listeners.AppContextListener;
import be.intecbrussel.blogProject.service.implementations.BlogPostService;
import be.intecbrussel.blogProject.service.interfaces.BlogPostServiceInterface;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;
import java.io.IOException;
import java.util.List;

/**
 * Mr. Black && Mr. Pink
 */
@WebServlet("/Home")
public class HomeServlet extends HttpServlet {

    private static final String BLOG_CENTRAL_PAGE = "WEB-INF/theBlog/fullPages/blogCentral.jsp";
    private BlogPostServiceInterface blogPostService;
    private BlogPostDAO blogPostDAO = new BlogPostDAO();
    public static final String ALL = "all";

    /**
     * @author Mr. Black
     */
    @Override
    public void init() throws ServletException {
        blogPostService = (BlogPostService) getServletContext().getAttribute(AppContextListener.BLOG_SERVICE);
        if (blogPostService == null) {
            throw new ServletException("BlogPostService not available");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        List<BlogPostBean> all = blogPostService.readBlogPostByRecentDate();
        session.setAttribute(ALL, all);
        request.getRequestDispatcher(BLOG_CENTRAL_PAGE).forward(request, response);
    }
}
