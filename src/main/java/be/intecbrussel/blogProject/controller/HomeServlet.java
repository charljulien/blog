package be.intecbrussel.blogProject.controller;

import be.intecbrussel.blogProject.beans.BlogPostBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Home")
public class HomeServlet extends HttpServlet {

    private static final String HOME_PAGE= "WEB-INF/theBlog/fullPages/blogCentral.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        HttpSession session = request.getSession();

        String article = "test article"; //temporary test String
//        String article = get blogPost from userService from database

        BlogPostBean blogPostBean = new BlogPostBean(article);

        session.setAttribute("blogPostBean", blogPostBean);

        request.getRequestDispatcher(HOME_PAGE).forward(request, response);
    }
}
