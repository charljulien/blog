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
 * Class creates Servlet login for JSP pages
 *
 * @author Mr. Pink
 */

@WebServlet("/Login")
public class UserLoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.getRequestDispatcher("/WEB-INF/forms/login.jsp").forward(request, response);
    }

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        if (userName != null && !userName.trim().isEmpty()){
            HttpSession session = request.getSession();
            if (session.getAttribute("userName")==null){
                session.setAttribute("userName", userName);
            }
//            UserService userService = new UserService();
            UserBean userBean = new UserBean();
//            userBean.setUserName(request.getParameter("userName"));
//            userService.handlingUser(userBean);
            request.setAttribute("userBean", userBean);
            request.getRequestDispatcher("WEB-INF/theBlog/combinationsAkaPages/blogCentral.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("WEB-INF/forms/ERRORlogin.jsp").forward(request, response);
        }
    }
}
