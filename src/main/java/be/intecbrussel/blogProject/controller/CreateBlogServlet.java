package be.intecbrussel.blogProject.controller;

import be.intecbrussel.blogProject.beans.BlogPostBean;
import be.intecbrussel.blogProject.beans.UserBean;
import be.intecbrussel.blogProject.service.implementations.BlogPostService;
import be.intecbrussel.blogProject.listeners.AppContextListener;
import be.intecbrussel.blogProject.service.interfaces.BlogPostServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static be.intecbrussel.blogProject.controller.UserLoginServlet.USER_BEAN;

/**
 * adds a Blog and adds this blog to the HomePage
 *
 * @author Mr. Black
 * @see BlogPostService#saveBlogPostToDB(BlogPostBean, UserBean)
 * @see BlogPostBean
 * @see UserBean
 */
@WebServlet("/Post")
public class CreateBlogServlet extends HttpServlet {

    private BlogPostServiceInterface blogPostService;
    private static final String BLOG_POST_SERVICE = "blogPostService";
    private static final String TITLE_POST = "title";
    private static final String POST = "postBlog";
    private static final String BLOG_POST_PAGE = "/WEB-INF/forms/BlogPostInput.jsp";


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
        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute(USER_BEAN);

        BlogPostBean blogPostBean = new BlogPostBean(request.getParameter(TITLE_POST), request.getParameter(POST));
        blogPostService.saveBlogPostToDB(blogPostBean, user);

        session.setAttribute(BLOG_POST_SERVICE, blogPostBean);
        response.sendRedirect("./Home");
    }

}
