package be.intecbrussel.blogProject.controller;

import be.intecbrussel.blogProject.beans.UserBean;
import be.intecbrussel.blogProject.listeners.AppContextListener;
import be.intecbrussel.blogProject.service.implementations.UserService;
import be.intecbrussel.blogProject.service.interfaces.UserServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/UserProfile")
public class UserProfileServlet extends HttpServlet {
    private UserServiceInterface userService;

    private static final String USER_PROFILE = "/WEB-INF/theBlog/fullPages/parts/userprofile.jsp";
    private static final String USER_NAME = "userName";

    @Override
    public void init() throws ServletException {
        userService = (UserService) getServletContext().getAttribute(AppContextListener.USER_SERVICE);
        if (userService == null) {
            throw new ServletException("User Service not available");
        }
    }

    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute(USER_NAME);

        UserBean userBean = userService.getUserByUserName(userName);
        session.setAttribute("userBean", userBean);
        request.getRequestDispatcher(USER_PROFILE).forward(request,response);
    }
}
