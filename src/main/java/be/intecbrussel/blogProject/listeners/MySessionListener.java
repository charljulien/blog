package be.intecbrussel.blogProject.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import static be.intecbrussel.blogProject.controller.UserLoginServlet.USER_BEAN;

@WebListener
public class MySessionListener implements HttpSessionListener {
    private int totalSessions = 0;
    private int sessionsActive = 0;

    /**
     * Method responsible for saving user object, blog post object, etc into each session UPON creation of that session.
     * According to Bart this is possible, but what if you create new blog post object in the middle of your session?!
     *
     * @author Miss Gold
     */
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {//listens bij new session, we zien die dan in tomcat cmd venster
        System.out.println("A SESSION WAS BORN");
        sessionsActive++;
        totalSessions++;
        System.out.println("SESSIONS SO FAR = " + totalSessions);
        System.out.println("ACTIVE SESSIONS = " + sessionsActive);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        sessionsActive--;
        System.out.println("A SESSION HAS PERISHED!");
        System.out.println("THERE ARE " + sessionsActive + " SESSIONS ACTIVE ATM.");
    }
}
