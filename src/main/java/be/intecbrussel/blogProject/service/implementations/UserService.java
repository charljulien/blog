package be.intecbrussel.blogProject.service.implementations;

import be.intecbrussel.blogProject.beans.UserBean;
import be.intecbrussel.blogProject.dao.MemberAccessDAO;
import be.intecbrussel.blogProject.dao.UserDAO;
import be.intecbrussel.blogProject.service.interfaces.UserServiceInterface;

import java.util.List;

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
    private MemberAccessDAO memberAccessDAO;

    // Constructor
    public UserService() {
        userDAO = new UserDAO();
        memberAccessDAO = new MemberAccessDAO();
    }

    // Methods

    /**
     * @author Mr. Black
     * @see UserDAO#saveUser(UserBean)
     * @see MemberAccessDAO#setReaderAccessLevel(UserBean)
     */
    @Override
    public void saveUserToDB(UserBean user) {
        System.out.println("Saving User SERVICE...");
        memberAccessDAO.setReaderAccessLevel(user);
        userDAO.saveUser(user);
    }



    public UserBean handlingUser(UserBean user) {
        System.out.println("Handling" + user.getUserName());
        //Iets met sessionDAO om nieuw sessie te creeren ?
        return user;
    }

    /**
     * @author Mr. Black
     * @see UserDAO#deleteUser(long)
     */
    @Override
    public void deleteUserFromDB(long id) {
        System.out.println("Deleting User SERVICE...");
        userDAO.deleteUser(id);
    }

    /**
     * @author Mr. Black
     * @see UserDAO#validateInLog(String, String)
     * */
    @Override
    public boolean validateInLogFromDB(String userName, String password) {
        System.out.println("Validating Login SERVICE...");
        return userDAO.validateInLog(userName, password);
    }

    /**
     * @author Mr. Black
     * to print in the console when making new user!
     */
    public void userRegistrationService(UserBean user) {
        System.out.println(user.toString());
    }

    /**
     * @author Mr. Black
     *
     * BETA TYPE
     * */
    public List<UserBean> getUserByPassword(String password){
        System.out.println("Getting User By Password < SERVICE >");
        return userDAO.getUserByPassword(password);
    }

    /**
    * @author Mr. Black
     * BETA TYPE
    * */
    public UserBean getUserByUserName(String userName){
        System.out.println("Getting User By UserName < SERVICE >");
        return userDAO.getUserByUserName(userName);
    }

}
