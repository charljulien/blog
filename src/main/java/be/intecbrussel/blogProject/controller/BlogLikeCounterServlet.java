package be.intecbrussel.blogProject.controller;

import be.intecbrussel.blogProject.beans.BlogPostBean;
import be.intecbrussel.blogProject.beans.UserBean;
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

import static be.intecbrussel.blogProject.controller.BlogPostServlet.BLOG_POST_SERVICE;
import static be.intecbrussel.blogProject.controller.UserLoginServlet.USER_BEAN;

@WebServlet("/Like")
public class BlogLikeCounterServlet extends HttpServlet {

    private static final String LIKE_COUNTER = "likeCounter";
    private static final String BLOG_POST_PAGE = "/WEB-INF/theBlog/fullPages/blogpost.jsp";

    private BlogPostServiceInterface blogPostService;


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
        request.getRequestDispatcher(BLOG_POST_PAGE).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        // To get the logged in user and to save it to a UserBean
//        UserBean user = (UserBean) session.getAttribute(USER_BEAN);
        BlogPostBean blog = (BlogPostBean) session.getAttribute(BLOG_POST_SERVICE);

  //      Integer like = Integer.parseInt(request.getParameter(LIKE_COUNTER));

        blogPostService.likeBlogPostCountIncrease(blog.getId());
        session.setAttribute(BLOG_POST_SERVICE, blog);
        request.getRequestDispatcher("WEB-INF/theBlog/fullPages/blogpost.jsp").forward(request, response);

    }
}
