package be.intecbrussel.blogProject.service.implementations;

import be.intecbrussel.blogProject.beans.UserBean;
import be.intecbrussel.blogProject.dao.UserDAO;
import be.intecbrussel.blogProject.service.interfaces.UserServiceInterface;

public class UserService implements UserServiceInterface {

    // Variables
    private UserDAO userDAO;

    // Constructor
    public UserService(){
        userDAO = new UserDAO();
    }

    // Methods
    @Override
    public void saveUserToDB(UserBean user) {
        userDAO.saveUser(user);
    }
}
