package be.intecbrussel.blogProject.controller;

import be.intecbrussel.blogProject.beans.UserBean;
import be.intecbrussel.blogProject.service.implementations.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Class creates Servlet object for JSP pages
 *
 * @author Mr. Pink
 */

@WebServlet("/Login")
public class UserLoginServlet extends HttpServlet {

    private static final String USER_BEAN = "userBean";
    private static final String LOGIN_PAGE = "/WEB-INF/forms/login.jsp";
    private static final String BLOG_CENTRAL_PAGE = "WEB-INF/theBlog/combinationsAkaPages/blogCentral.jsp";
    private static final String ERROR_LOGIN_PAGE = "WEB-INF/forms/ERROR_login.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.getRequestDispatcher("/WEB-INF/forms/login.jsp").forward(request, response);
    }

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String text = request.getParameter("userName");

        if (text != null && !text.trim().isEmpty()){
            HttpSession session = request.getSession();
            if (session.getAttribute("userName")==null){
                session.setAttribute("userName", text);
            }
//            UserService userService = new UserService();
            UserBean userBean = new UserBean();
//            userBean.setUserName(request.getParameter("userName"));
//            userService.handlingUser(userBean);
            request.setAttribute(USER_BEAN, userBean);
            request.getRequestDispatcher("WEB-INF/theBlog/combinationsAkaPages/blogCentral.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("WEB-INF/forms/ERROR_login.jsp").forward(request, response);
        }
    }
}
