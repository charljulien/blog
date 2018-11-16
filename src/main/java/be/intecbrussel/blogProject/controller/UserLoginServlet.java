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

/**
 * Class creates Servlet login for JSP pages
 *
 * @author Mr. Pink
 */

@WebServlet("/Login")
public class UserLoginServlet extends HttpServlet {

    // Variables
    private static final String USER_BEAN = "userBean";
    private static final String USER_NAME = "userName";
    private static final String PASSWORD = "password";

    private static final String LOGIN_PAGE = "/WEB-INF/forms/login.jsp";
    private static final String BLOG_CENTRAL_PAGE = "WEB-INF/theBlog/combinationsAkaPages/blogCentral.jsp";
    private static final String ERROR_LOGIN_PAGE = "WEB-INF/forms/ERROR_login.jsp";

    private UserServiceInterface userService;

    // Methods

    /**
     * @author Mr. Black
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userName = request.getParameter(USER_NAME);
        String password = request.getParameter(PASSWORD);

<<<<<<< HEAD
        if (userName != null && !userName.trim().isEmpty() && password != null && !password.trim().isEmpty()){
=======
        if (userName != null && !userName.trim().isEmpty()) {
>>>>>>> 41a138b9fa3e1ff249a84853b46114d8c1065e68
            HttpSession session = request.getSession();
            if (session.getAttribute(USER_NAME) == null) {
                session.setAttribute(USER_NAME, userName);
            }
            if (session.getAttribute("password")==null){
                session.setAttribute("password", password);
            }
            UserBean userBean = new UserBean();
//            userBean.setUserName(request.getParameter("userName"));
<<<<<<< HEAD
//            userServiceInterface.handlingUser(userBean);
            request.setAttribute("userBean", userBean);
            request.getRequestDispatcher("WEB-INF/theBlog/combinationsAkaPages/blogCentral.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("WEB-INF/forms/ERRORlogin.jsp").forward(request, response);
=======
//            userService.handlingUser(userBean);
            request.setAttribute(USER_BEAN, userBean);
            userService.handlingUser(userBean);
            request.setAttribute(USER_BEAN, userBean);
            request.getRequestDispatcher(BLOG_CENTRAL_PAGE).forward(request, response);
        } else {
            request.getRequestDispatcher(ERROR_LOGIN_PAGE).forward(request, response);
>>>>>>> 41a138b9fa3e1ff249a84853b46114d8c1065e68
        }
    }
}
