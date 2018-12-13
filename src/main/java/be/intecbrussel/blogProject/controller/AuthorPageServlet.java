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
import java.util.List;

import static be.intecbrussel.blogProject.controller.UserLoginServlet.USER_BEAN;

/**
 * Shows all Blogs by a certain UserBean
 *
 * @author Mr. Pink && Mr. Black
 * @see BlogPostService#readBlogsByPredefinedUser(String)
 * @see BlogPostService
 * @see BlogPostBean
 * @see UserBean
 */

@WebServlet("/AuthorPage")
public class AuthorPageServlet extends HttpServlet {

    private BlogPostServiceInterface blogPostService;
    private static final String AUTHOR = "author";
    private static final String AUTHOR_PAGE = "WEB-INF/theBlog/fullPages/authorPage.jsp";


    @Override
    public void init() throws ServletException {
        blogPostService = (BlogPostService) getServletContext().getAttribute(AppContextListener.BLOG_SERVICE);
        if (blogPostService == null) {
            throw new ServletException("BlogPostService not available");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute(USER_BEAN);

        List<BlogPostBean> blogPostByUser = blogPostService.readBlogsByPredefinedUser(user.getUserName());
        session.setAttribute(AUTHOR, blogPostByUser);
        System.out.println(blogPostByUser);
        request.getRequestDispatcher(AUTHOR_PAGE).forward(request, response);
    }

}
