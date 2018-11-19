package be.intecbrussel.blogProject.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Singleton EntityManagerFactory && EntityManager
 * @author Mr. Black
 */
public class EMProvidor {

    // Variables
    private static final String DB_SCHEMA = "theblog";
    private static final boolean DEBUG = true;
    private static EMProvidor ourInstance = new EMProvidor();
    private static EntityManagerFactory emf;
    private EntityManager em;

    // Constructor
    private EMProvidor() {

    }

    // Methods
    public static EMProvidor getInstance() {
        return ourInstance;
    }

    /**
     * Creates an EntityManagerFactory
     */
    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(DB_SCHEMA);
        }
        if (DEBUG) {
            System.out.println("Entity Manager Factory created on " + new Date());
        }
        return emf;
    }

    /**
     * Creates an EntityManager via
     *
     * @see EMProvidor#getEntityManagerFactory()
     */
    public static EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    public void closeEmf() {
        if (emf.isOpen() || emf != null) {
            emf.close();
        }
        emf = null;
        if (DEBUG) {
            System.out.println("Entity Manager Factory closed at: " + new Date());
        }
    }

    public void closeEM(){
        getEntityManager().close();
    }


}
