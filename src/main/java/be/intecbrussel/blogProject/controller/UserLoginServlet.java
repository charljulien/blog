package be.intecbrussel.blogProject.controller;

import be.intecbrussel.blogProject.beans.UserBean;
import be.intecbrussel.blogProject.service.implementations.UserService;
import be.intecbrussel.blogProject.service.interfaces.UserServiceInterface;
import be.intecbrussel.blogProject.sessionListeners.AppContextListener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Class creates Servlet login for JSP pages
 *
 * @author Mr. Pink
 */

@WebServlet("/Login")
public class UserLoginServlet extends HttpServlet {

    // Variables
    public static final String USER_BEAN = "userBean";

    private static final String USER_NAME = "userName";
    private static final String PASSWORD = "password";

    private static final String LOGIN_PAGE = "/WEB-INF/forms/login.jsp";
    private static final String BLOG_CENTRAL_PAGE = "WEB-INF/theBlog/combinationsAkaPages/blogCentral.jsp";
    private static final String ERROR_LOGIN_PAGE = "WEB-INF/forms/ERRORlogin.jsp";

    private UserServiceInterface userService;

    // Methods

    /**
     * @author Mr. Black
     * getServletContex() cast to UserService by Mr Pink
     */
    @Override
    public void init() throws ServletException {
        userService = (UserService) getServletContext().getAttribute(AppContextListener.USER_SERVICE);
        if (userService == null) {
            throw new ServletException("User Service not available");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
    }


    /**
     * To compare doPost from Mr Black, no need for extra if else normally
     *
     * @author Mr. Pink && Mr. Black
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userName = request.getParameter(USER_NAME);
        String password = request.getParameter(PASSWORD);



        if ((userName != null && !userName.trim().isEmpty()) && (password != null && !password.trim().isEmpty())) {
            HttpSession session = request.getSession();
            if (session.getAttribute(USER_NAME) == null) {
                session.setAttribute(USER_NAME, userName);
            }
            if (session.getAttribute(PASSWORD) == null) {
                session.setAttribute(PASSWORD, password);
            }

            boolean userNameVal = userService.validateInLogFromDB(userName, password);
            UserBean userBean = new UserBean();


            if (userNameVal) {
                List<UserBean> userLog = userService.getUserByUserName(userName);
                System.out.println("USERLOG OK "+userLog.toString());
                request.getSession().setAttribute(USER_BEAN, userLog);
                request.getRequestDispatcher(BLOG_CENTRAL_PAGE).forward(request, response);

            } else if (!userNameVal) {
                request.getRequestDispatcher(ERROR_LOGIN_PAGE).forward(request, response);
            }

        } else {
            request.getRequestDispatcher(ERROR_LOGIN_PAGE).forward(request, response);
        }
    }
}
