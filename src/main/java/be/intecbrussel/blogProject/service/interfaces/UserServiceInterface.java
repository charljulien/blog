package be.intecbrussel.blogProject.service.interfaces;

import be.intecbrussel.blogProject.beans.UserBean;

/**
 * UserService Interface for UserBean class
 *
 * @author Mr. Black
 * @see UserBean
 * @see be.intecbrussel.blogProject.dao.UserDAO
 */
public interface UserServiceInterface {

    /**
     * @see be.intecbrussel.blogProject.dao.UserDAO#saveUser(UserBean)
     */
    void saveUserToDB(UserBean user);

}
