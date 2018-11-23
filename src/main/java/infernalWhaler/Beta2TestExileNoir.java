package infernalWhaler;

import be.intecbrussel.blogProject.beans.UserBean;
import be.intecbrussel.blogProject.dao.BlogPostDAO;
import be.intecbrussel.blogProject.dao.EMProvidor;
import be.intecbrussel.blogProject.dao.UserDAO;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class Beta2TestExileNoir {

    private Scanner kbd;
    private EntityManager em;
    private UserDAO userDAO;
    private BlogPostDAO blogPostDAO;

    Beta2TestExileNoir(){
        kbd = new Scanner(System.in);
        em = EMProvidor.getEntityManager();
        userDAO = new UserDAO();
        blogPostDAO = new BlogPostDAO();
    }

    public static void main(String[] args) {
        Beta2TestExileNoir b = new Beta2TestExileNoir();
       b.blogPostDAO.likeBlogPostCountIncrease(1);
    }
}
