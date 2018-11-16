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
            userServiceInterface.handlingUser(userBean);
            request.setAttribute("userBean", userBean);
            request.getRequestDispatcher("WEB-INF/theBlog/combinationsAkaPages/blogCentral.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("WEB-INF/forms/ERRORlogin.jsp").forward(request, response);
        }
    }
}
