package be.intecbrussel.blogProject.controller;

import be.intecbrussel.blogProject.beans.BlogPostBean;
import be.intecbrussel.blogProject.dao.BlogPostDAO;
import be.intecbrussel.blogProject.listeners.AppContextListener;
import be.intecbrussel.blogProject.service.implementations.BlogPostService;
import be.intecbrussel.blogProject.service.interfaces.BlogPostServiceInterface;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/Home")
public class HomeServlet extends HttpServlet {

    private static final String HOME_PAGE = "WEB-INF/theBlog/fullPages/blogCentral.jsp";
    private BlogPostServiceInterface blogPostService;
    private BlogPostDAO blogPostDAO = new BlogPostDAO();

    /**
     * @author Mr. Black
     */
    @Override
    public void init() throws ServletException {
        blogPostService = (BlogPostService) getServletContext().getAttribute(AppContextListener.BLOG_SERVICE);
        if (blogPostService == null) {
            throw new ServletException("BlogPostService not available");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

//        String articleTitle = "title";
//        String article = "test article"; //temporary test String
////        String article = get blogPost from userService from database
//
//        BlogPostBean blogPostBean = new BlogPostBean(articleTitle, article);
//
//        session.setAttribute("blogPostBean", blogPostBean);
//
//        request.getRequestDispatcher(HOME_PAGE).forward(request, response);


//        String id = request.getParameter("id");
//        if(id==null) {
//            List<BlogPostBean> byDate = blogPostDAO.getAllBlogs();
//            request.setAttribute("byDate", byDate);
//            request.getRequestDispatcher("WEB-INF/theBlog/fullPages/parts/blogpostBody.js");
//        } else {
//            BlogPostBean blog = blogPostDAO.getBlogWithPredefinedId(Integer.parseInt(id));
//            request.setAttribute("blog",blog);
//            request.getRequestDispatcher("");
//        }

        List<BlogPostBean> all = blogPostDAO.readBlogPost();
        System.out.println(all);
        request.setAttribute("all", all);
        request.getRequestDispatcher("WEB-INF/theBlog/fullPages/blogCentral.jsp").forward(request,response);

    }
}
