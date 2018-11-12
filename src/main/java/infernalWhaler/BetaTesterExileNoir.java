package infernalWhaler;

import be.intecbrussel.blogProject.beans.UserBean;
import be.intecbrussel.blogProject.dao.EMProvidor;
import be.intecbrussel.blogProject.service.implementations.UserService;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class BetaTesterExileNoir {

    /*
    * ExileNoir BetaTester:
    * Connectivity SaveUserToDB works!! --> OK!
    * */

    private UserService userService;
    private Scanner kbd;
    private EntityManager em = EMProvidor.getEntityManager();

    BetaTesterExileNoir(){
        userService = new UserService();
        kbd = new Scanner(System.in);
    }

    private void saveUser(){
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

    public static void main(String[] args) {

        BetaTesterExileNoir beta = new BetaTesterExileNoir();
        beta.saveUser();
    }
}
