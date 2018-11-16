package be.intecbrussel.blogProject.controller;

import be.intecbrussel.blogProject.beans.UserBean;
import be.intecbrussel.blogProject.exception.InvalidContextAttributeException;
import be.intecbrussel.blogProject.service.implementations.UserService;
import be.intecbrussel.blogProject.service.interfaces.UserServiceInterface;
import org.hibernate.ObjectNotFoundException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InvalidObjectException;

/**
 * Class creates Servlet login for JSP pages
 *
 * @author Mr. Pink
 */

@WebServlet("/Login")
public class UserLoginServlet extends HttpServlet {
    UserServiceInterface userServiceInterface;

//    public void init(){
//        System.out.println("init youuhouu");
//
//        Object userServiceObject = getServletContext().getAttribute("userService");
//        if(userServiceObject instanceof UserServiceInterface){
//            userServiceInterface = (UserServiceInterface)userServiceObject;
//        }else{
//            throw new InvalidContextAttributeException();
//        }
//    }

    private static final String USER_BEAN = "userBean";
    private static final String LOGIN_PAGE = "/WEB-INF/forms/login.jsp";
    private static final String BLOG_CENTRAL_PAGE = "WEB-INF/theBlog/combinationsAkaPages/blogCentral.jsp";
    private static final String ERROR_LOGIN_PAGE = "WEB-INF/forms/ERROR_login.jsp";

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
            UserBean userBean = new UserBean();
//            userBean.setUserName(request.getParameter("userName"));
<<<<<<< HEAD
//            userService.handlingUser(userBean);
            request.setAttribute(USER_BEAN, userBean);
=======
            userServiceInterface.handlingUser(userBean);
            request.setAttribute("userBean", userBean);
>>>>>>> 014215b2329a0e7613036ede9507c3208005d037
            request.getRequestDispatcher("WEB-INF/theBlog/combinationsAkaPages/blogCentral.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("WEB-INF/forms/ERRORlogin.jsp").forward(request, response);
        }
    }
}
