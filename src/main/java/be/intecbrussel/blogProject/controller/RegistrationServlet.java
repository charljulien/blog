package be.intecbrussel.blogProject.controller;

import be.intecbrussel.blogProject.beans.UserBean;
import be.intecbrussel.blogProject.service.implementations.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class creates Servlet login for JSP pages
 *
 * @author Mr. Pink
 */

@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {

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
    private static final String BLOG_CENTRAL_PAGE = "WEB-INF/theBlog/combinationsAkaPages/blogCentral.jsp";

    private static final String USER_SERVICE = "userService";

    private List<String> items;
    private UserService userService;
    private UserBean userBean;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher(REGISTRATION_PAGE).forward(request, response);
    }

    /**
     * @author Mr. Pink
     * conditional statement does not work, check validity
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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

        //if he did shit, he goes to the error page, that's the spirit
        if (isEmpty) {
            request.getRequestDispatcher(REGISTRATION_ERROR).forward(request, response);
        }
        //otherwise he goes to main page and his profile is created with method configureUserBean
        else {
            request.getRequestDispatcher(BLOG_CENTRAL_PAGE).forward(request, response);
            userBean = new UserBean();
            userBean = configureUserBean(userBean, request);
            userService = (UserService) getServletContext().getAttribute(USER_SERVICE);
            userService.saveUserToDB(userBean);
        }
    }

    /**
     * @author Mr. Pink
     * methode to create a list of parameter to check validity
     */
    public List<String> getItems(HttpServletRequest request) {
        String firstName = request.getParameter(FIRST_NAME);
        String lastName = request.getParameter(LAST_NAME);
        String email = request.getParameter(EMAIL);
        String street = request.getParameter(STREET);
        String houseNumber = request.getParameter(HOUSE_NUMBER);
        String city = request.getParameter(CITY);
        String zipCode = request.getParameter(ZIP_CODE);
        String userName = request.getParameter(USER_NAME);
        String password = request.getParameter(PASSWORD);

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
    public UserBean configureUserBean(UserBean userBean, HttpServletRequest request) {
        userBean.setFirstname(request.getParameter(FIRST_NAME));
        userBean.setLastName(request.getParameter(LAST_NAME));
        userBean.setEmail(request.getParameter(EMAIL));
        userBean.setStreet(request.getParameter(STREET));
        userBean.setHouseNr(request.getParameter(HOUSE_NUMBER));
        userBean.setCity(request.getParameter(CITY));
        userBean.setZipCode(request.getParameter(ZIP_CODE));
        userBean.setUserName(request.getParameter(USER_NAME));
        userBean.setPassword(request.getParameter(PASSWORD));

        return userBean;
    }
}
