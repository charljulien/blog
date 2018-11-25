package be.intecbrussel.blogProject.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Class creates Servlet logout for JSP pages
 *
 * @author Mr. Pink && Mr. Black
 */
@WebServlet("/Logout")
public class UserLogoutServlet extends HttpServlet {

    private static final String HOME_PAGE = "WEB-INF/theBlog/fullPages/blogCentral.jsp";

    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        HttpSession session = request.getSession(false);
        if (session !=null){
            session.invalidate();
        }
        request.getRequestDispatcher(HOME_PAGE).forward(request,response);
    }
}
