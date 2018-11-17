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

    List<String> items;
    UserService userService;
    UserBean userBean;

//    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
//        request.getRequestDispatcher("WEB-INF/forms/registration.jsp").forward(request, response);


    private static final String REGISTRATION_PAGE = "WEB-INF/forms/registration.jsp";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher(REGISTRATION_PAGE).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        items = new ArrayList<>();
        items = getItems(request);
        boolean isEmpty = false;

        //first we check if new user didn't left empty information in regsitration
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
            request.getRequestDispatcher("WEB-INF/forms/ERRORregistration.jsp");
        }
        //otherwise he goes to main page and his profile is created
        else {
            userBean = configureUserBean(userBean, request);
            userService = (UserService) getServletContext().getAttribute("userService");
            userService.saveUserToDB(userBean);
            request.getRequestDispatcher("WEB-INF/theBlog/combinationsAkaPages/blogCentral.jsp");
        }
    }

    /**
     * @author Mr. Pink
     */
    //methode to create a list of parameters
    public List<String> getItems(HttpServletRequest request) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String street = request.getParameter("street");
        String houseNumber = request.getParameter("houseNumber");
        String city = request.getParameter("city");
        String zipCode = request.getParameter("zipCode");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

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
     */
    //methode to create user with valid parameters
    public UserBean configureUserBean(UserBean userBean, HttpServletRequest request) {
        userBean.setFirstname(request.getParameter("firstName"));
        userBean.setLastName(request.getParameter("lastName"));
        userBean.setEmail(request.getParameter("email"));
        userBean.setStreet(request.getParameter("street"));
        userBean.setHouseNr(request.getParameter("houseNumber"));
        userBean.setCity(request.getParameter("city"));
        userBean.setZipCode(request.getParameter("zipCode"));
        userBean.setUserName(request.getParameter("userName"));
        userBean.setPassword(request.getParameter("password"));

        return userBean;
    }
}
