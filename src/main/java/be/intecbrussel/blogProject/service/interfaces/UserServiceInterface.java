package be.intecbrussel.blogProject.service.interfaces;

import be.intecbrussel.blogProject.beans.UserBean;

/**
 * UserService Interface for UserBean class
 *
 * @author Mr. Black
 * @see be.intecbrussel.blogProject.beans.UserBean
 * @see be.intecbrussel.blogProject.dao.UserDAO
 */
public interface UserServiceInterface {

    /**
     * @see be.intecbrussel.blogProject.dao.UserDAO#saveUser(UserBean)
     */
    void saveUserToDB(UserBean user);
    /**
     * @see be.intecbrussel.blogProject.dao.UserDAO#deleteUser(long)
     * */
    void deleteUserFromDB(long id);

}
