package be.intecbrussel.blogProject.service.interfaces;

import be.intecbrussel.blogProject.beans.UserBean;

import java.util.List;

/**
 * UserService Interface for UserBean class
 *
 * @author Mr. Black
 * @see be.intecbrussel.blogProject.beans.UserBean
 * @see be.intecbrussel.blogProject.dao.UserDAO
 */
public interface UserServiceInterface {

    /**
     * @author Mr. Black
     * @see be.intecbrussel.blogProject.dao.UserDAO#saveUser(UserBean)
     * @see be.intecbrussel.blogProject.service.implementations.UserService#saveUserToDB(UserBean)
     */
    void saveUserToDB(UserBean user);

    /**
     * @author Mr. Black
     * @see be.intecbrussel.blogProject.dao.UserDAO#deleteUser(long)
     * @see be.intecbrussel.blogProject.service.implementations.UserService#deleteUserFromDB(long)
     */
    void deleteUserFromDB(long id);

    /**
     * @see be.intecbrussel.blogProject.dao.UserDAO#validateInLog(String, String)
     * @author Mr. Black
     * */
    boolean validateInLogFromDB(String userName, String password);


    /**
     * @author Mr. Black
     * @see be.intecbrussel.blogProject.dao.UserDAO#getUserByPassword(String)
     * @see be.intecbrussel.blogProject.service.implementations.UserService#getUserByPassword(String)
     */
    List<UserBean> getUserByPassword(String password);

    /**
     * @author Mr. Black
     * @see be.intecbrussel.blogProject.dao.UserDAO#getUserByUserName(String)
     * @see be.intecbrussel.blogProject.service.implementations.UserService#getUserByUserName(String)
     */
    UserBean getUserByUserName(String userName);


    List<UserBean> readAllUsers();

}
