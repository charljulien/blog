package be.intecbrussel.blogProject.dao;

import be.intecbrussel.blogProject.beans.UserBean;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

/**
 * Represents the dataLayer of UserBean class
 *
 * @author Mr. Black
 * @see UserBean
 * @see be.intecbrussel.blogProject.service.interfaces.UserServiceInterface
 */
public class UserDAO {

    // Variables
    private EntityManager em;
    private EntityTransaction et;

    /**
     * Saves a User to DB
     *
     * @param user object to create
     * @author Mr. Black
     * @see be.intecbrussel.blogProject.service.interfaces.UserServiceInterface#saveUserToDB(UserBean)
     */
    public void saveUser(UserBean user) {
        System.out.println("Saving user DAO...");
        em = EMProvidor.getEntityManager();
        et = em.getTransaction();
        et.begin();
        em.merge(user);
        et.commit();
    }

    /**
     * Update user in DB
     * @author Mr.Brown
     *
     * @param user
     */
    public void updateUser(long id, String text) {
        System.out.println("Updating user DAO...");
        em = EMProvidor.getEntityManager();
        et = em.getTransaction();
        et.begin();
        List<UserBean> ub = getUserById(id);
        for (UserBean user : ub) {
            user.setFirstname(user.getFirstname() + " " + text);
            user.setLastName(user.getLastName() + " " + text);
            user.setUserName(user.getUserName() + " " + text);
            user.setEmail(user.getEmail() + " " + text);
            user.setStreet(user.getStreet() + " " + text);
            user.setHouseNr(user.getHouseNr() + " " + text);
            user.setCity(user.getCity() + " " + text);
            user.setZipCode(user.getZipCode() + " " + text);
            user.setPassword(user.getPassword() + " " + text);
            em.merge(user);
        }
        et.commit();
    }

    // Read

    /**
     * Delete User from DB
     *
     * @param id from User
     * @author Mr. Black
     */
    public void deleteUser(long id) {
        System.out.println("Deleting User DAO");
        em = EMProvidor.getEntityManager();
        et = em.getTransaction();
        et.begin();
        List<UserBean> users = getUserById(id);
        for (UserBean user : users) {
            em.remove(user);
        }
        et.commit();
    }


    /**
     * Query to obtain User by LastName
     *
     * @param lastName for object UserBean
     * @return query user with predefined String
     * @author Mr. Black
     * @see UserDAO#getUserByLastName(String)
     */
    private TypedQuery<UserBean> getUserByLastNameQuery(String lastName) {
        TypedQuery<UserBean> query = em.createQuery("SELECT user FROM UserBean AS user WHERE user.lastName=:last", UserBean.class);
        query.setParameter("last", lastName);
        return query;
    }

    /**
     * List to obtain LastName of user
     *
     * @param lastName for object UserBean
     * @return User
     * @author Mr. Black
     */
    public List<UserBean> getUserByLastName(String lastName) {
        return getUserByLastNameQuery(lastName).getResultList();
    }

    /**
     * Query to obtain User by id
     *
     * @param id of object User
     * @return query user with predefined long
     * @author Mr. Black
     * @see UserDAO#getUserById(long)
     */
    private TypedQuery<UserBean> getUserByIdQuery(long id) {
        TypedQuery<UserBean> query = em.createQuery("SELECT user FROM UserBean AS user WHERE user.id=:id", UserBean.class);
        query.setParameter("id", id);
        return query;
    }

    /**
     * List to obtain Id of User
     *
     * @param id of object User
     * @return User
     * @author Mr. Black
     */
    public List<UserBean> getUserById(long id) {
        return getUserByIdQuery(id).getResultList();
    }


}
