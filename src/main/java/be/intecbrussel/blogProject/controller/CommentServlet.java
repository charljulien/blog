package be.intecbrussel.blogProject.controller;

import be.intecbrussel.blogProject.beans.BlogPostBean;
import be.intecbrussel.blogProject.beans.CommentBean;
import be.intecbrussel.blogProject.beans.UserBean;
import be.intecbrussel.blogProject.dao.BlogPostDAO;
import be.intecbrussel.blogProject.listeners.AppContextListener;
import be.intecbrussel.blogProject.service.implementations.CommentService;
import be.intecbrussel.blogProject.service.implementations.UserService;
import be.intecbrussel.blogProject.service.interfaces.CommentServiceInterface;
import be.intecbrussel.blogProject.service.interfaces.UserServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


import static be.intecbrussel.blogProject.controller.BlogArticle.BLOG;
import static be.intecbrussel.blogProject.controller.UserLoginServlet.USER_BEAN;

/**
 * @author Mr. Black
 */
@WebServlet("/Comment")
public class CommentServlet extends HttpServlet {

    private static final String COMMENT = "comment";
    private static final String BLOG_ARTICLE = "/WEB-INF/theBlog/fullPages/blogArticle.jsp";

    public static final String COMMENT_SERVICE = "commentService";

    private CommentServiceInterface commentService;
    private CommentBean commentBean;
    private UserServiceInterface userService;
    private BlogPostDAO blogPostDAO = new BlogPostDAO();

    @Override
    public void init() throws ServletException {
        commentService = (CommentService) getServletContext().getAttribute(AppContextListener.COMMENT_SERVICE);
        if (commentService == null) {
            throw new ServletException("Comment Service not available");
        }
        userService = (UserService) getServletContext().getAttribute(AppContextListener.USER_SERVICE);
        if (userService == null) {
            throw new ServletException("User Service not available");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher(BLOG_ARTICLE).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute(USER_BEAN);
        BlogPostBean blog = (BlogPostBean) session.getAttribute(BLOG);

        commentBean = new CommentBean(request.getParameter(COMMENT));
        commentService.saveCommentToDB(commentBean, user, blog);

        session.setAttribute(COMMENT_SERVICE, commentBean);

        request.getRequestDispatcher(BLOG_ARTICLE).forward(request, response);
    }

}
