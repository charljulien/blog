package be.intecbrussel.blogProject.controller;

import be.intecbrussel.blogProject.beans.BlogPostBean;
import be.intecbrussel.blogProject.beans.UserBean;
import be.intecbrussel.blogProject.dao.BlogPostDAO;
import be.intecbrussel.blogProject.dao.UserDAO;
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
import java.io.PrintWriter;
import java.util.List;

import static be.intecbrussel.blogProject.controller.UserLoginServlet.USER_BEAN;

/**
 * @author Mr. Pink
 */

@WebServlet("/AuthorPage")
public class AuthorHomeServlet extends HttpServlet {


    private BlogPostServiceInterface blogPostService;
    private UserDAO userDAO = new UserDAO();

    private static final String AUTHOR_PAGE = "WEB-INF/theBlog/fullPages/authorPage.jsp";


    @Override
    public void init() throws ServletException {
        blogPostService = (BlogPostService) getServletContext().getAttribute(AppContextListener.BLOG_SERVICE);
        if (blogPostService == null) {
            throw new ServletException("BlogPostService not available");
        }
    }

/**
 * Mr. Black this does not fully work yet....
 * */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute(USER_BEAN);

        List<BlogPostBean> blogPostByUser = blogPostService.readBlogsByPredefinedUser(user.getUserName());
        session.setAttribute("author", blogPostByUser);
        System.out.println(blogPostByUser);
        request.getRequestDispatcher(AUTHOR_PAGE).forward(request,response);
    }
}
