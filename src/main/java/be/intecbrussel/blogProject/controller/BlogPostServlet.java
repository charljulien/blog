package be.intecbrussel.blogProject.controller;

import be.intecbrussel.blogProject.beans.BlogPostBean;
import be.intecbrussel.blogProject.beans.UserBean;
import be.intecbrussel.blogProject.service.implementations.BlogPostService;
import be.intecbrussel.blogProject.listeners.AppContextListener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static be.intecbrussel.blogProject.controller.UserLoginServlet.USER_BEAN;

/**
 * @author Mr. Black
 */
@WebServlet("/Post")
public class BlogPostServlet extends HttpServlet {

    private static final String TITLE_POST = "title";
    private static final String POST = "postBlog";

    private static final String BLOG_CENTRAL_PAGE = "WEB-INF/theBlog/combinationsAkaPages/blogCentral.jsp";
    private static final String BLOG_POST_PAGE = "/WEB-INF/forms/BlogPostInput.jsp";

    private static final String BLOG_POST_SERVICE = "blogPostService";

    private BlogPostService blogPostService;
    private BlogPostBean blogPostBean;

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
        UserBean user = (UserBean) session.getAttribute(USER_BEAN);

        blogPostBean = new BlogPostBean(request.getParameter(TITLE_POST), request.getParameter(POST));

        // Saving the Blog and UserBean (logged in user) to DB
        blogPostService.saveBlogPostToDB(blogPostBean, user);

        session.setAttribute(BLOG_POST_SERVICE, blogPostBean);
        session.setAttribute(USER_BEAN, blogPostBean);


        request.getRequestDispatcher("WEB-INF/theBlog/fullPages/blogpost.jsp").forward(request, response);
    }
}
