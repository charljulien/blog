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

    Connection connection = null;
    private static final String UPDATE = "UPDATE users SET FirstName=?, LastName=?, UserName=?, Email=?, Street=?, House_no=?, City=?, Zip=?, Password=? WHERE id=?";

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
        List<UserBean> eMail = getUserByMail(user.getEmail());
        List<UserBean> userName = getUserByUserName(user.getUserName());
        boolean eMailExists = false;
        boolean userNameExists = false;
        for (UserBean mail : eMail) {
            if (user.getEmail().equalsIgnoreCase(mail.getEmail())) {
                System.out.println("Email already exists");
                eMailExists = true;
            }
        }
        for (UserBean username : userName){
            if(user.getUserName().equalsIgnoreCase(username.getUserName())){
                System.out.println("UserName already exists");
                userNameExists = true;
            }
        }
        if (!eMailExists && !userNameExists) {
            em.merge(user);
        }
        et.commit();
        EMProvidor.closeEmf();
    }

    /**
     * Update user in DB
     * Mr.Brown
     *
     * @param user
     */
    public void updateUser(UserBean user) {
        try {
            PreparedStatement p = (PreparedStatement) connection.prepareStatement(UPDATE);
            p.setString(1, user.getFirstname());
            p.setString(2, user.getLastName());
            p.setString(3, user.getUserName());
            p.setString(4, user.getEmail());
            p.setString(5, user.getStreet());
            p.setString(6, user.getHouseNr());
            p.setString(7, user.getCity());
            p.setString(8, user.getZipCode());
            p.setString(9, user.getPassword());

            p.executeUpdate();
            p.close();

            System.out.println("User " + user.getId() + "was updated");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
        EMProvidor.closeEmf();
    }


    /**
     * Query to obtain User by LastName
     *
     * @param lastName for object UserBean
     * @return query user with predefined lastName String
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
     * @param id of object UserBean
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
     * List to obtain Id of UserBean
     *
     * @param id of object UserBean
     * @return User
     * @author Mr. Black
     */
    public List<UserBean> getUserById(long id) {
        return getUserByIdQuery(id).getResultList();
    }

    /**
     * Query to obtain UserBean by Email
     *
     * @param mail for object UserBean
     * @return for object UserBean with predefined Email String
     * @author Mr. Black
     * @see UserDAO#getUserByMail(String)
     */
    private TypedQuery<UserBean> getUserByMailQuery(String mail) {
        TypedQuery<UserBean> query = em.createQuery("SELECT user FROM UserBean AS user WHERE user.email=:email", UserBean.class);
        query.setParameter("email", mail);
        return query;
    }

    /**
     * List to obtain UserBean by Email
     *
     * @param mail for object UserBean
     * @return User
     * @author Mr. Black
     */
    public List<UserBean> getUserByMail(String mail) {
        return getUserByMailQuery(mail).getResultList();
    }

    /**
     * Query to obtain UserBean by UserName
     *
     * @param userName for object UserBean
     * @return for object UserBean with predefined UserName String
     * @author Mr. Black
     * @see UserDAO#getUserByUserName(String)
     */
    private TypedQuery<UserBean> getUserByUserNameQuery(String userName) {
        TypedQuery<UserBean> query = em.createQuery("SELECT user FROM UserBean AS user WHERE user.userName=:user", UserBean.class);
        query.setParameter("user", userName);
        return query;
    }

    /**
     * List to obtain UserBean by UserName
     *
     * @param username for object UserBean
     * @return User
     * @author Mr. Black
     */
    public List<UserBean> getUserByUserName(String username) {
        return getUserByUserNameQuery(username).getResultList();
    }

}
