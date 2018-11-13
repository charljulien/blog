package infernalWhaler;

import be.intecbrussel.blogProject.beans.CommentBean;
import be.intecbrussel.blogProject.beans.UserBean;
import be.intecbrussel.blogProject.dao.EMProvidor;
import be.intecbrussel.blogProject.service.implementations.CommentService;
import be.intecbrussel.blogProject.service.implementations.UserService;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class BetaTesterExileNoir {

    /*
    * ExileNoir BetaTester:
    * Connectivity SaveUserToDB works!! --> OK!
    * */

    // Variables
    private UserService userService;
    private CommentService commentService;
    private Scanner kbd;
    private EntityManager em = EMProvidor.getEntityManager();
    // Constructor
    BetaTesterExileNoir(){
        userService = new UserService();
        commentService = new CommentService();
        kbd = new Scanner(System.in);
    }
    // Test One
    private void saveUser(){
        System.out.println("input User");
        String fname = kbd.nextLine();
        String lname = kbd.nextLine();
        String user = kbd.nextLine();
        String mail = kbd.nextLine();
        String street = kbd.nextLine();
        String no = kbd.nextLine();
        String city = kbd.nextLine();
        String zip = kbd.nextLine();
        String pass = kbd.nextLine();
        UserBean userBean = new UserBean(fname,lname,user,mail,street,no,city,zip,pass);

        userService.saveUserToDB(userBean);
    }
    // Test Two
    private void saveComment(){
        System.out.println("input Comment");
        String message = kbd.nextLine();
        CommentBean commentBean = new CommentBean(message);
        commentService.saveCommentToDB(commentBean);
    }

    public static void main(String[] args) {

        BetaTesterExileNoir beta = new BetaTesterExileNoir();
        beta.saveComment();
    }
}
