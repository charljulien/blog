package be.intecbrussel.blogProject.service.interfaces;

import be.intecbrussel.blogProject.beans.MemberAccess;
import be.intecbrussel.blogProject.beans.UserBean;

/**
 * MemberAccessService Interface for MemberAccess class
 *
 * @author Mr. Black
 * @see MemberAccess
 * @see be.intecbrussel.blogProject.dao.MemberAccessDAO
 */
public interface MemberAccessServiceInterface {

    /**
     * @see be.intecbrussel.blogProject.dao.MemberAccessDAO#createAccessLevel(MemberAccess)
     */
    void saveAccessLevelToDB(MemberAccess memberAccess);

    /**
     * @see be.intecbrussel.blogProject.dao.MemberAccessDAO#setReaderAccessLevel(UserBean)
     */
    void setReaderAccessLevel(UserBean userBean);
}
