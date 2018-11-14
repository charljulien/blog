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
    private static final String DELETE = "DELETE FROM users WHERE id=?";

    // Variables
    private EntityManager em;
    private EntityTransaction et;

    /**
     * Saves a User to DB
     *
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
     * Mr.Brown
     * @param user
     */

    //Update

    public void updateUser(UserBean user){


            try {
                PreparedStatement p = (PreparedStatement) connection.prepareStatement(UPDATE);
                p.setString(1,user.getFirstname());
                p.setString(2,user.getLastName());
                p.setString(3,user.getUserName());
                p.setString(4,user.getEmail());
                p.setString(5,user.getStreet());
                p.setString(6,user.getHouseNr());
                p.setString(7,user.getCity());
                p.setString(8,user.getZipCode());
                p.setString(9,user.getPassword());

                p.executeUpdate();
                p.close();

                System.out.println("User " + user.getId() + "was updated");

            }catch ( SQLException e){
                throw new RuntimeException(e);
            }

    }

    // Read

    /**
     * Delete User in DB
     * Mr.Brown
     * @param id
     */
    // Delete

    public void delete(int id){


        try {
            PreparedStatement p = (PreparedStatement) connection.prepareStatement(DELETE);

            p.setInt(1,id);

            p.executeUpdate();
            p.close();

            System.out.println("User " + id + "was deleted");

        }catch ( SQLException e){
            throw new RuntimeException(e);
        }

    }




    /**
     * Query to obtain User by LastName
     *
     * @param lastName
     * @return query LastName
     * @see UserDAO#getUserByLastName(String)
     */
    private TypedQuery<UserBean> getUserByLastNameQuery(String lastName) {
        TypedQuery<UserBean> query = em.createQuery("SELECT user FROM UserBean as user where user.lastName=:last", UserBean.class);
        query.setParameter("last", lastName);
        return query;
    }

    /**
     * List to obtain LastName of user
     *
     * @return lastName
     */
    public List<UserBean> getUserByLastName(String lastName) {
        return getUserByLastNameQuery(lastName).getResultList();
    }


}
