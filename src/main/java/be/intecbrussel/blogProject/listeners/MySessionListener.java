package be.intecbrussel.blogProject.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

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
        System.out.println("a session was born");
        sessionsActive++;
        totalSessions++;
        System.out.println("sessions so far =" + totalSessions);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        sessionsActive--;
        System.out.println("a session has perished");
        System.out.println("there are " + sessionsActive + " sessions active atm.");
    }
}
