package be.intecbrussel.blogProject.dao;

import be.intecbrussel.blogProject.beans.UserBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
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
        for (UserBean username : userName) {
            if (user.getUserName().equalsIgnoreCase(username.getUserName())) {
                System.out.println("UserName already exists");
                userNameExists = true;
            }
        }
        if (!eMailExists && !userNameExists) {
            em.merge(user);
        }
        et = em.getTransaction();
        et.begin();
        et.commit();
        EMProvidor.getInstance().closeEM();
    }


    // this should be adjusted... change user itself without looking for certain id!!!!

    /**
     * Update user in DB
     *
     * @param id
     * @param text
     * @author Mr.Brown
     */
    public void updateUser(long id, String text) {
        System.out.println("Updating user DAO...");
        em = EMProvidor.getEntityManager();
        et = em.getTransaction();
        et.begin();
        List<UserBean> ub = getUserById(id);
        for (UserBean user : ub) {
            user.setFirstName(user.getFirstName() + " " + text);
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
        EMProvidor.getInstance().closeEM();
    }

    // Read

    /**
     * Delete User from DB
     *
     * @param id from User
     * @author Mr. Black
     */
    public void deleteUser(long id) {
        System.out.println("Deleting User DAO...");
        em = EMProvidor.getEntityManager();
        et = em.getTransaction();
        et.begin();
        List<UserBean> users = getUserById(id);
        for (UserBean user : users) {
            em.remove(user);
        }
        et.commit();
        EMProvidor.getInstance().closeEM();
    }

    public void deleteUser(String userName) {

    }

    public boolean validateInLog(String userName, String password) {
        System.out.println("Validating Login DAO...");
        em = EMProvidor.getEntityManager();
        List<UserBean> userNameVal = getUserByUserName(userName);
        List<UserBean> passwordVal = getUserByPassword(password);
        boolean statusUserName = false;
        boolean statusPassword = false;
        boolean statusOk = false;

        for (UserBean nameUser : userNameVal) {
            if (userName.equals(nameUser.getUserName())) {
                System.out.println("UserName is Correct");
                statusUserName = true;
            }
            if (statusUserName) {
                if (nameUser.getUserName().equals(userName)&& nameUser.getPassword().equals(password)) {
                    System.out.println("Password is Correct");
                    statusPassword = true;
                }
            }
        }

        if (statusUserName && statusPassword) {
            statusOk = true;
        }

        EMProvidor.getInstance().closeEM();
        return statusOk;
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
        em = EMProvidor.getEntityManager();
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
        em = EMProvidor.getEntityManager();
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
        em = EMProvidor.getEntityManager();
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
     * @return object UserBean with predefined UserName String
     * @author Mr. Black
     * @see UserDAO#getUserByUserName(String)
     */
    private TypedQuery<UserBean> getUserByUserNameQuery(String userName) {
        em = EMProvidor.getEntityManager();
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

    /**
     * Query to obtain UserBean by Password
     *
     * @param password for object UserBean
     * @return object UserBean with predefined Password String
     * @author Mr. Black
     * @see UserDAO#getUserByPassword(String)
     */
    private TypedQuery<UserBean> getUserByPasswordQuery(String password) {
        em = EMProvidor.getEntityManager();
        TypedQuery<UserBean> query = em.createQuery("SELECT user FROM UserBean AS user WHERE user.password=:pass", UserBean.class);
        query.setParameter("pass", password);
        return query;
    }

    /**
     * List to obtain UserBean by Password
     *
     * @param password for oject UserBean
     * @return User
     * @author Mr. Black
     */
    public List<UserBean> getUserByPassword(String password) {
        return getUserByPasswordQuery(password).getResultList();
    }

}
