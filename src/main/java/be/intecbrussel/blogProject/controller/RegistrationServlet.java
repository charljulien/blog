package be.intecbrussel.blogProject.controller;

import be.intecbrussel.blogProject.beans.UserBean;
import be.intecbrussel.blogProject.service.implementations.BlogPostService;
import be.intecbrussel.blogProject.service.implementations.UserService;
import be.intecbrussel.blogProject.service.interfaces.BlogPostServiceInterface;
import be.intecbrussel.blogProject.service.interfaces.UserServiceInterface;
import be.intecbrussel.blogProject.listeners.AppContextListener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static be.intecbrussel.blogProject.controller.UserLoginServlet.getBlogByRecentDateAndAddToBlogCentralPage;

/**
 * Registration page for new Users
 *
 * @author Mr. Pink && Mr Black
 * @see GetUserInfoByParameter InnerClass for getItems() Registration
 * @see UserService#saveUserToDB(UserBean)
 * @see BlogPostService
 * @see UserBean
 */

@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {

    private BlogPostServiceInterface blogPostService;
    private UserServiceInterface userService;
    private List<String> items;
    private static final String USER_SERVICE = "userService";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String EMAIL = "email";
    private static final String STREET = "street";
    private static final String HOUSE_NUMBER = "houseNumber";
    private static final String CITY = "city";
    private static final String ZIP_CODE = "zipCode";
    private static final String USER_NAME = "userName";
    private static final String PASSWORD = "password";
    private static final String REGISTRATION_PAGE = "WEB-INF/forms/registration.jsp";
    private static final String REGISTRATION_ERROR = "WEB-INF/forms/ERRORregistration.jsp";
    private static final String BLOG_CENTRAL_PAGE = "WEB-INF/theBlog/fullPages/blogCentral.jsp";


    @Override
    public void init() throws ServletException {
        userService = (UserService) getServletContext().getAttribute(AppContextListener.USER_SERVICE);
        if (userService == null) {
            throw new ServletException("UserService not available");
        }
        blogPostService = (BlogPostService) getServletContext().getAttribute(AppContextListener.BLOG_SERVICE);
        if (blogPostService == null) {
            throw new ServletException("BlogPostService not available");
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher(REGISTRATION_PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // hier list zetten als local niet instance
        items = new ArrayList<>();
        items = getItems(request);
        boolean isEmpty = false;

        //first we check if parameters are valid, that is to say no empty parameters
        for (String i : items) {
            if (i == null || i.trim().isEmpty()) {
                isEmpty = true;
                break;
            } else {
                continue;
            }
        }
        if (isEmpty) {
            request.getRequestDispatcher(REGISTRATION_ERROR).forward(request, response);
        }
        //otherwise he goes to main page and his profile is created with method configureUserBean
        else {
            UserBean userBean = new UserBean();
            configureUserBean(userBean, request);

            userService.saveUserToDB(userBean);
            request.getSession().setAttribute(USER_SERVICE, userBean);
            getBlogByRecentDateAndAddToBlogCentralPage(request, response, blogPostService, BLOG_CENTRAL_PAGE);
        }
    }


    /**
     * @author Mr. Pink
     * methode to create a list of parameter to check validity
     */
    private List<String> getItems(HttpServletRequest request) {
        GetUserInfoByParameter getUserInfoByParameter = new GetUserInfoByParameter(request).invoke();
        String firstName = getUserInfoByParameter.getFirstName();
        String lastName = getUserInfoByParameter.getLastName();
        String email = getUserInfoByParameter.getEmail();
        String street = getUserInfoByParameter.getStreet();
        String houseNumber = getUserInfoByParameter.getHouseNumber();
        String city = getUserInfoByParameter.getCity();
        String zipCode = getUserInfoByParameter.getZipCode();
        String userName = getUserInfoByParameter.getUserName();
        String password = getUserInfoByParameter.getPassword();

        items.add(firstName);
        items.add(lastName);
        items.add(email);
        items.add(street);
        items.add(houseNumber);
        items.add(city);
        items.add(zipCode);
        items.add(userName);
        items.add(password);

        return items;
    }

    /**
     * @author Mr. Pink
     * methode to create user with yet validated parameters
     */
    private void configureUserBean(UserBean userBean, HttpServletRequest request) {
        userBean.setFirstName(request.getParameter(FIRST_NAME));
        userBean.setLastName(request.getParameter(LAST_NAME));
        userBean.setEmail(request.getParameter(EMAIL));
        userBean.setStreet(request.getParameter(STREET));
        userBean.setHouseNr(request.getParameter(HOUSE_NUMBER));
        userBean.setCity(request.getParameter(CITY));
        userBean.setZipCode(request.getParameter(ZIP_CODE));
        userBean.setUserName(request.getParameter(USER_NAME));
        userBean.setPassword(request.getParameter(PASSWORD));
    }

    /**
     * InnerClass for getItems() Registration
     *
     * @author Mr. Black
     * @see RegistrationServlet#getItems(HttpServletRequest)
     */
    private class GetUserInfoByParameter {
        private HttpServletRequest request;
        private String firstName;
        private String lastName;
        private String email;
        private String street;
        private String houseNumber;
        private String city;
        private String zipCode;
        private String userName;
        private String password;

        GetUserInfoByParameter(HttpServletRequest request) {
            this.request = request;
        }

        String getFirstName() {
            return firstName;
        }

        String getLastName() {
            return lastName;
        }

        String getEmail() {
            return email;
        }

        String getStreet() {
            return street;
        }

        String getHouseNumber() {
            return houseNumber;
        }

        String getCity() {
            return city;
        }

        String getZipCode() {
            return zipCode;
        }

        String getUserName() {
            return userName;
        }

        String getPassword() {
            return password;
        }

        GetUserInfoByParameter invoke() {
            firstName = request.getParameter(FIRST_NAME);
            lastName = request.getParameter(LAST_NAME);
            email = request.getParameter(EMAIL);
            street = request.getParameter(STREET);
            houseNumber = request.getParameter(HOUSE_NUMBER);
            city = request.getParameter(CITY);
            zipCode = request.getParameter(ZIP_CODE);
            userName = request.getParameter(USER_NAME);
            password = request.getParameter(PASSWORD);
            return this;
        }
    }
}
