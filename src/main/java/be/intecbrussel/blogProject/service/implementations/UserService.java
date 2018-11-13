package be.intecbrussel.blogProject.service.implementations;

import be.intecbrussel.blogProject.beans.UserBean;
import be.intecbrussel.blogProject.dao.UserDAO;
import be.intecbrussel.blogProject.service.interfaces.UserServiceInterface;

/**
 * Represents ServiceLayer of UserBean class
 *
 * @author Mr. Black
 * @see UserBean
 * @see UserDAO
 */
public class UserService implements UserServiceInterface {

    // Variables
    private UserDAO userDAO;

    // Constructor
    public UserService() {
        userDAO = new UserDAO();
    }

    // Methods
    /**
     * @see UserDAO#saveUser(UserBean)
     */
    @Override
    public void saveUserToDB(UserBean user) {
        System.out.println("Saving user SERVICE");
        userDAO.saveUser(user);
    }
}
