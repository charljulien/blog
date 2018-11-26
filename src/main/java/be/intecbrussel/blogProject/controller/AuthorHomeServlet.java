package be.intecbrussel.blogProject.controller;

import be.intecbrussel.blogProject.beans.BlogPostBean;
import be.intecbrussel.blogProject.beans.UserBean;
import be.intecbrussel.blogProject.dao.BlogPostDAO;
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
    private BlogPostServiceInterface blogPostServiceInterface;
    private BlogPostDAO blogPostDAO = new BlogPostDAO();

    private static final String AUTHOR_PAGE = "WEB-INF/theBlog/fullPages/authorPage.jsp";
    private static final String USER_NAME = "userName";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute(USER_NAME);
        List<BlogPostBean> blogPostByUser = blogPostDAO.getBlogsByPredefinedUser(USER_NAME);
        System.out.println(blogPostByUser);
        request.setAttribute("blogPostByUser", blogPostByUser);
        request.getRequestDispatcher(AUTHOR_PAGE).forward(request,response);
    }
}
