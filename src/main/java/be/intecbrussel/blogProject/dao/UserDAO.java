package be.intecbrussel.blogProject.dao;

import be.intecbrussel.blogProject.beans.BlogPostBean;
import be.intecbrussel.blogProject.beans.UserBean;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

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


        UserBean userName = getUserByUserName(user.getUserName());
        boolean eMailExists = false;
        boolean userNameExists = false;

        if(userName != null){
            if (user.getEmail().equalsIgnoreCase(userName.getEmail())) {
                System.out.println("Email already exists");
                eMailExists = true;
            }


            if (user.getUserName().equalsIgnoreCase(userName.getUserName()) ) {
                System.out.println("user already exists");
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

    public List<UserBean> readUserBlogs(String userName){
        em = EMProvidor.getEntityManager();
        return getUserBeanBlogs(userName);
    }


    // this should be adjusted... change user itself without looking for certain id!!!!

    /**
     * @param choice
     * @param user
     * @author Mr.brown
     */
    public void updateUser(char choice, UserBean user) {
        System.out.println("Updating user DAO...");
        em = EMProvidor.getEntityManager();
        et = em.getTransaction();
        et.begin();

        System.out.println("a: Do you want to update your Firstname ");
        System.out.println("b: Do you want to update your Lastname ");
        System.out.println("c: Do you want to update your Username ");
        System.out.println("d: Do you want to update your Email ");
        System.out.println("e: Do you want to update your Street ");
        System.out.println("f: Do you want to update your HousNr ");
        System.out.println("g: Do you want to update your City ");
        System.out.println("h: Do you want to update your ZipCode  ");
        System.out.println("i: Do you want to update your Password ");
        Scanner kbd = new Scanner(System.in);
        choice = kbd.next().charAt(0);

        switch (choice) {
            case 'a':
                user.setFirstName(user.getFirstName());
                break;
            case 'b':
                user.setLastName(user.getLastName());
                break;
            case 'c':
                user.setUserName(user.getUserName());
                break;
            case 'd':
                user.setEmail(user.getEmail());
                break;
            case 'e':
                user.setStreet(user.getStreet());
                break;
            case 'f':
                user.setHouseNr(user.getHouseNr());
                break;
            case 'g':
                user.setCity(user.getCity());
                break;
            case 'h':
                user.setZipCode(user.getZipCode());
                break;
            case 'i':
                user.setPassword(user.getPassword());
                break;
        }
        em.merge(user);
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
        UserBean userNameVal = getUserByUserName(userName);
        boolean statusUserName = false;
        boolean statusPassword = false;
        boolean statusOk = false;

        if (userName.equals(userNameVal.getUserName())) {
            System.out.println("UserName is Correct");
            statusUserName = true;
        }
        if (statusUserName) {
            if (userNameVal.getPassword().equals(password)) {
                System.out.println("Password is Correct");
                statusPassword = true;
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
     * Obtain UserBean by UserName
     *
     * @param username for object UserBean
     * @return User
     * @author Mr. Black
     */
    public UserBean getUserByUserName(String username) {
        UserBean userBean = null;
        try {
            userBean = getUserByUserNameQuery(username).getSingleResult();
        }
        catch (Exception ex){}
        return userBean;
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
     * @return List User
     * @author Mr. Black
     */
    public List<UserBean> getUserByPassword(String password) {
        return getUserByPasswordQuery(password).getResultList();
    }

    private TypedQuery<UserBean> getUserBeanBlogsQuery(String userName){
        em = EMProvidor.getEntityManager();
        TypedQuery<UserBean> query = em.createQuery("SELECT user.blogs FROM UserBean AS user Where user.userName=:userName",UserBean.class);
        query.setParameter("userName",userName);
        return query;
    }

    public List<UserBean> getUserBeanBlogs(String userName){
        return getUserBeanBlogsQuery(userName).getResultList();
    }

}
