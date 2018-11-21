package infernalWhaler;

import be.intecbrussel.blogProject.beans.BlogPostBean;
import be.intecbrussel.blogProject.beans.CommentBean;
import be.intecbrussel.blogProject.beans.MemberAccess;
import be.intecbrussel.blogProject.beans.UserBean;
import be.intecbrussel.blogProject.dao.EMProvidor;
import be.intecbrussel.blogProject.dao.MemberAccessDAO;
import be.intecbrussel.blogProject.service.implementations.BlogPostService;
import be.intecbrussel.blogProject.service.implementations.CommentService;
import be.intecbrussel.blogProject.service.implementations.MemberAccessService;
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
    private MemberAccessService memberAccessService;
    private BlogPostService blogPostService;
    private Scanner kbd;
    private EntityManager em = EMProvidor.getEntityManager();
    private  MemberAccessDAO memberAccessDAO;
    // Constructor
    BetaTesterExileNoir(){
        userService = new UserService();
        commentService = new CommentService();
        memberAccessService = new MemberAccessService();
        blogPostService = new BlogPostService();
        kbd = new Scanner(System.in);

       memberAccessDAO = new MemberAccessDAO();
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

    private void saveAccessLevel(){
        System.out.println("Give level");
        String level = kbd.next();
        MemberAccess access = new MemberAccess(level);
        memberAccessService.saveAccessLevelToDB(access);

    }

    private void saveBlogPost(){


        System.out.println("Give message");
        System.out.println("Give name");
        blogPostService.saveBlogPostToDB(new BlogPostBean(kbd.nextLine(),kbd.nextLine()),kbd.nextLine());

    }

    private void deleteComment(){
        System.out.println("Give ID number");
        long id = kbd.nextLong();
        commentService.deleteCommentToDB(id);
    }

    private void updateBlogPost(){
        System.out.println("Give first ID and then TEXT");
        long id = kbd.nextLong();
        kbd.nextLine();
        String text = kbd.nextLine();
        blogPostService.updateBlogPostToDB(id,text);
    }

    public static void main(String[] args) {

        BetaTesterExileNoir beta = new BetaTesterExileNoir();
        beta.saveBlogPost();
    }
}
