package infernalWhaler;

import be.intecbrussel.blogProject.beans.UserBean;
import be.intecbrussel.blogProject.dao.EMProvidor;
import be.intecbrussel.blogProject.dao.UserDAO;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class Beta2TestExileNoir {

    private Scanner kbd;
    private EntityManager em;
    private UserDAO userDAO;

    Beta2TestExileNoir(){
        kbd = new Scanner(System.in);
        em = EMProvidor.getEntityManager();
        userDAO = new UserDAO();
    }

    public static void main(String[] args) {
        Beta2TestExileNoir b = new Beta2TestExileNoir();
        b.userDAO.saveUser(new UserBean("Steven","Deseure","user","mail","test","test","test","test","test"));
    }
}
