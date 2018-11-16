package be.intecbrussel.blogProject.service.implementations;

import be.intecbrussel.blogProject.beans.UserBean;
import be.intecbrussel.blogProject.dao.MemberAccessDAO;
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
}
