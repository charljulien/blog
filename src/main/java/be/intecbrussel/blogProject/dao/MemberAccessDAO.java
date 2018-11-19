package be.intecbrussel.blogProject.dao;

import be.intecbrussel.blogProject.beans.MemberAccess;
import be.intecbrussel.blogProject.beans.UserBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Represents DataLayer of MemberAccess class
 *
 * @author Mr. Black
 * @see MemberAccess
 * @see be.intecbrussel.blogProject.service.interfaces.MemberAccessServiceInterface
 */
public class MemberAccessDAO {

    // Variables
    private EntityManager em;
    private EntityTransaction et;

    /**
     * Creates an Access Level
     *
     * @param memberAccess object
     * @author Mr. Black
     * @see be.intecbrussel.blogProject.service.interfaces.MemberAccessServiceInterface#saveAccessLevelToDB(MemberAccess)
     */
    public void createAccessLevel(MemberAccess memberAccess) {
        System.out.println("Saving Access Level DAO...");
        em = EMProvidor.getEntityManager();

        List<MemberAccess> accessLevel = getMemberAccessLevel(memberAccess.getMemberAccessLevel());
        boolean accessLevelExists = false;
        for (MemberAccess level : accessLevel) {
            if (memberAccess.getMemberAccessLevel().equalsIgnoreCase(level.getMemberAccessLevel())) {
                accessLevelExists = true;
            }
        }
        System.out.println("found access level" + accessLevelExists);
        if (!accessLevelExists) {
            System.out.println("Adding memberaccess to PC: " + memberAccess);
            em.persist(memberAccess);
        }
        et = em.getTransaction();
        et.begin();
        et.commit();
        EMProvidor.getInstance().closeEM();
    }

    /**
     * Sets a default Access Level << READER >> to new user
     * This Methods should be used when creating a new UserBean to set default Reader Access
     *
     * @param user by creation of new user object
     * @author Mr. Black
     * @see be.intecbrussel.blogProject.service.interfaces.MemberAccessServiceInterface#setReaderAccessLevel(UserBean)
     */
    public void setReaderAccessLevel(UserBean user) {
        System.out.println("Setting Access Level to no defined Users DAO...");
        em = EMProvidor.getEntityManager();
        et = em.getTransaction();
        et.begin();
        List<MemberAccess> defaultAccess = getReaderAccess();
        for (MemberAccess level : defaultAccess) {
            level.addMember(user);
            em.persist(level);
        }
        et.commit();
        EMProvidor.getInstance().closeEM();
    }


    /**
     * Query to find a User without a defined access level
     *
     * @author Mr. Black
     * @see MemberAccessDAO#getNoLevelDefinedUsers()
     */
    private TypedQuery<UserBean> getNoLevelDefinedUsersQuery() {
        em = EMProvidor.getEntityManager();
        TypedQuery<UserBean> query = em.createQuery("SELECT user FROM UserBean  AS user where user.memberAccess=:level", UserBean.class);
        query.setParameter("level", null);
        return query;
    }

    public List<UserBean> getNoLevelDefinedUsers() {
        return getNoLevelDefinedUsersQuery().getResultList();
    }

    /**
     * Query to obtain << Reader >> Access Level
     *
     * @return query Reader
     * @author Mr. Black
     * @see MemberAccessDAO#getReaderAccess()
     */
    private TypedQuery<MemberAccess> getReaderAccessQuery() {
        em = EMProvidor.getEntityManager();
        TypedQuery<MemberAccess> query = em.createQuery("SELECT access FROM MemberAccess AS access where memberAccessLevel=:default", MemberAccess.class);
        query.setParameter("default", "Reader");
        return query;
    }

    /**
     * List to obtain Reader Access Level
     *
     * @return Reader
     * @author Mr. Black
     */
    public List<MemberAccess> getReaderAccess() {
        return getReaderAccessQuery().getResultList();
    }

    /**
     * Query to obtain String value accessLevel for members
     *
     * @param accessLevel represents the AccessLevel to search
     * @author Mr. Black
     * @see MemberAccessDAO#getMemberAccessLevel(String)
     */
    private TypedQuery<MemberAccess> getMemberAccessLevelQuery(String accessLevel) {
        em = EMProvidor.getEntityManager();
        TypedQuery<MemberAccess> query = em.createQuery("SELECT access FROM MemberAccess AS access WHERE access.memberAccessLevel=:level", MemberAccess.class);
        query.setParameter("level", accessLevel);
        return query;
    }

    /**
     * List to obtain predefined AccessLevel
     *
     * @return AccessLevel value
     * @author Mr. Black
     */
    public List<MemberAccess> getMemberAccessLevel(String accessLevel) {
        return getMemberAccessLevelQuery(accessLevel).getResultList();
    }
}
