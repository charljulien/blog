package be.intecbrussel.blogProject.service.implementations;

import be.intecbrussel.blogProject.beans.MemberAccess;
import be.intecbrussel.blogProject.beans.UserBean;
import be.intecbrussel.blogProject.dao.MemberAccessDAO;
import be.intecbrussel.blogProject.service.interfaces.MemberAccessServiceInterface;

/**
 * Represents the ServiceLayer of MemberAccess
 *
 * @author Mr. Black
 * @see MemberAccess
 * @see MemberAccessDAO
 */
public class MemberAccessService implements MemberAccessServiceInterface {

    // Variables
    private MemberAccessDAO memberAccessDAO;

    // Constructor
    public MemberAccessService() {
        memberAccessDAO = new MemberAccessDAO();
    }

    // Methods
    /**
     * @see MemberAccessDAO#createAccessLevel(MemberAccess)
     * */
    @Override
    public void saveAccessLevelToDB(MemberAccess memberAccess) {
        System.out.println("Saving Access Level SERVICE...");
        memberAccessDAO.createAccessLevel(memberAccess);
    }

    /**
     * @see MemberAccessDAO#setReaderAccessLevel(UserBean)
     * */
    public void setReaderAccessLevel(UserBean user) {
        System.out.println("Setting READER Access Level to user SERVICE...");
        memberAccessDAO.setReaderAccessLevel(user);
    }

}
