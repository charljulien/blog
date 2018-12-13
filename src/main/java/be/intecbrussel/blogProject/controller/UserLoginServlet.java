package be.intecbrussel.blogProject.controller;

import be.intecbrussel.blogProject.beans.BlogPostBean;
import be.intecbrussel.blogProject.beans.UserBean;
import be.intecbrussel.blogProject.exceptions.ErrorFool;
import be.intecbrussel.blogProject.service.implementations.BlogPostService;
import be.intecbrussel.blogProject.service.implementations.UserService;
import be.intecbrussel.blogProject.service.interfaces.BlogPostServiceInterface;
import be.intecbrussel.blogProject.service.interfaces.UserServiceInterface;
import be.intecbrussel.blogProject.listeners.AppContextListener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static be.intecbrussel.blogProject.listeners.AppContextListener.BLOG_SERVICE;

/**
 * Loges a User into the blogSite
 *
 * @author Mr. Pink && Mr. Black
 * @see UserService#validateInLogFromDB(String, String)
 * @see UserService#getUserByUserName(String)
 * @see BlogPostService#readBlogPostByRecentDate()
 * @see UserService
 * @see ErrorFool#getErreur()
 */

@WebServlet("/Login")
public class UserLoginServlet extends HttpServlet {

    private UserServiceInterface userService;
    private BlogPostServiceInterface blogPostService;
    public static final String USER_BEAN = "userBean";
    private static final String BLOG_ARTICLE = "blogArticle";
    private static final String USER_NAME = "userName";
    private static final String PASSWORD = "password";
    private static final String ERROR = "erreur";
    private static final String LOGIN_PAGE = "/WEB-INF/forms/login.jsp";
    private static final String BLOG_CENTRAL_PAGE = "WEB-INF/theBlog/fullPages/blogCentral.jsp";


    @Override
    public void init() throws ServletException {
        userService = (UserService) getServletContext().getAttribute(AppContextListener.USER_SERVICE);
        if (userService == null) {
            throw new ServletException("User Service not available");
        }
        blogPostService = (BlogPostService) getServletContext().getAttribute(BLOG_SERVICE);
        if (blogPostService == null) {
            throw new ServletException("BlogPost Service not available");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userName = request.getParameter(USER_NAME);
        String password = request.getParameter(PASSWORD);
        HttpSession session = request.getSession();

        try {
            if ((userName != null && !userName.trim().isEmpty()) && (password != null && !password.trim().isEmpty())) {
                boolean userNameVal = userService.validateInLogFromDB(userName, password);
                if (userNameVal) {
                    UserBean userLog = userService.getUserByUserName(userName);
                    System.out.println("USER LOG OK " + userLog.toString());

                    session.setAttribute(USER_BEAN, userLog);
                    getBlogByRecentDateAndAddToBlogCentralPage(request, response, blogPostService, BLOG_CENTRAL_PAGE);

                } else {
                    errorLogin(request, response);
                }
            } else {
                errorLogin(request, response);
            }
        } catch (NullPointerException npe) {
            errorLogin(request, response);
        }
    }


    static void getBlogByRecentDateAndAddToBlogCentralPage(HttpServletRequest request, HttpServletResponse response, BlogPostServiceInterface blogPostService, String blogCentralPage) throws ServletException, IOException {
        List<BlogPostBean> all = blogPostService.readBlogPostByRecentDate();
        System.out.println(all);
        request.setAttribute(BLOG_ARTICLE, all);
        request.getRequestDispatcher(blogCentralPage).forward(request, response);
    }

    private void errorLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ErrorFool errorFool = new ErrorFool();
        System.out.println("USER LOG INVALID..." + errorFool.getErreur());
        request.setAttribute(ERROR, errorFool);
        getBlogByRecentDateAndAddToBlogCentralPage(request, response, blogPostService, BLOG_CENTRAL_PAGE);
    }

}
