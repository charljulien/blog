package be.intecbrussel.blogProject.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//Miss Gold ;)
@WebServlet("/CreateBlogPost")
public class CreateBlogPostServlet extends HttpServlet {


    private static final String LOGIN_PAGE = "/WEB-INF/forms/login.jsp";

    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session !=null && request.isUserInRole("author")){ //add this user role somehow!! see descriptor
            session.invalidate();
        }
        request.getRequestDispatcher(LOGIN_PAGE).forward(request,response);
    }


}
