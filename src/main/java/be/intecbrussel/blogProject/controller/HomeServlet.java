package be.intecbrussel.blogProject.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Home")
public class HomeServlet extends HttpServlet {

    private static final String HOME_PAGE= "WEB-INF/theBlog/combinationsAkaPages/blogCentral.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.getRequestDispatcher(HOME_PAGE).forward(request, response);
    }
}
