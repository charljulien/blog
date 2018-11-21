package be.intecbrussel.blogProject.controller;

import be.intecbrussel.blogProject.beans.BlogPostBean;
import be.intecbrussel.blogProject.service.implementations.BlogPostService;
import be.intecbrussel.blogProject.listeners.AppContextListener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static be.intecbrussel.blogProject.controller.UserLoginServlet.USER_BEAN;

@WebServlet("/Post")
public class BlogPostServlet extends HttpServlet {

    private static final String TITLE_POST = "title";
    private static final String POST = "post";
    private static final String BLOG_CENTRAL_PAGE = "WEB-INF/theBlog/combinationsAkaPages/blogCentral.jsp";

    private static final String BLOG_POST_SERVICE = "blogPostService";

    BlogPostService blogPostService;
    BlogPostBean blogPostBean;

    @Override
    public void init() throws ServletException {
        blogPostService = (BlogPostService) getServletContext().getAttribute(AppContextListener.BLOG_SERVICE);
        if (blogPostService == null) {
            throw new ServletException("BlogPostService not available");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        HttpSession session = request.getSession();

        request.getRequestDispatcher(BLOG_CENTRAL_PAGE).forward(request, response);
        blogPostBean = new BlogPostBean(request.getParameter(TITLE_POST),request.getParameter(POST));
//      Below is already being initialized my << init() >>
//      blogPostService = (BlogPostService) getServletContext().getAttribute(BLOG_POST_SERVICE);
        session.getAttribute(USER_BEAN);
        blogPostService.saveBlogPostToDB(blogPostBean);
//      added my Mr. Black
        session.setAttribute(USER_BEAN, blogPostBean);
    }
}
