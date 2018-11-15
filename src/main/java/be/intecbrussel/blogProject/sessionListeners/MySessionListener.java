package be.intecbrussel.blogProject.sessionListeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MySessionListener implements HttpSessionListener {
    private int totalSessions = 0;
    private int sessionsActive = 0;

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
