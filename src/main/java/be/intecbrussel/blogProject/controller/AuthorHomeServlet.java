package be.intecbrussel.blogProject.controller;

import be.intecbrussel.blogProject.beans.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static be.intecbrussel.blogProject.controller.UserLoginServlet.USER_BEAN;

@WebServlet("/AuthorPage")
public class AuthorHomeServlet extends HttpServlet {
    private static final String AUTHOR_PAGE = "WEB-INF/theBlog/fullPages/authorPage.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(AUTHOR_PAGE).forward(request,response);
    }
}
