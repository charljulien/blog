package be.intecbrussel.blogProject.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {

    private static final String REGISTRATION_PAGE = "WEB-INF/forms/registration.jsp";

    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.getRequestDispatcher(REGISTRATION_PAGE).forward(request, response);
    }
}
