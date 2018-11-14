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
     * @see be.intecbrussel.blogProject.service.interfaces.MemberAccessServiceInterface#saveAccessLevelToDB(MemberAccess)
     */
    public void createAccessLevel(MemberAccess memberAccess) {
        System.out.println("Saving Access Level DAO...");
        em = EMProvidor.getEntityManager();
        et = em.getTransaction();
        et.begin();
        em.persist(memberAccess);
        et.commit();
    }

    /**
     * Sets a default Access Level << READER >> to new user
     * This Methods should be used when creating a new UserBean to set default Reader Access
     *
     * @param user by creation of new user
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

    }


    // Queries
    private TypedQuery<UserBean> getNoLevelDefinedUsersQuery() {
        TypedQuery<UserBean> query = em.createQuery("SELECT user FROM UserBean  AS user where user.memberAccess=:level", UserBean.class);
        query.setParameter("level", null);
        return query;
    }

    public List<UserBean> getNoLevelDefinedUsers() {
        return getNoLevelDefinedUsersQuery().getResultList();
    }

    /**
     * Query to obtain Reader Access Level
     *
     * @return query Reader
     * @see MemberAccessDAO#getReaderAccess()
     */
    private TypedQuery<MemberAccess> getReaderAccessQuery() {
        TypedQuery<MemberAccess> query = em.createQuery("SELECT acces FROM MemberAccess AS acces where memberAccessLevel=:default", MemberAccess.class);
        query.setParameter("default", "Reader");
        return query;
    }

    /**
     * List to obtain Reader Access Level
     *
     * @return Reader
     */
    public List<MemberAccess> getReaderAccess() {
        return getReaderAccessQuery().getResultList();
    }


}
