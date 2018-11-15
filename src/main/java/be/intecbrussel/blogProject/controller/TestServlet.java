package be.intecbrussel.blogProject.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(value = "/getsession")
public class TestServlet extends HttpServlet {

    //method chosen in form data ( html )
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //is there a session active?
        HttpSession session = request.getSession(false);

        //if no session active at all, create one :)
        if (session == null) {
            //OBJECTIVE: get login (param of request obj) & save it it sessie-Object as attribute

            //STEP 1: retrieve param from form data ( name input as String - kinda like key-value pair met this string as key? )
            String login = request.getParameter("sessionstext");

            //get newSession object van je request object
            HttpSession newSession = request.getSession();// getSession methode : session ophalen en indien het niet bestaat creeren!!! dus hier sowieso creeren

            //store param String as attribute in newSession
            request.setAttribute("user", login); //key-value pair ( i chose key! )

            //print user name in browser to welcome them ( and confirm login )
            response.getWriter().println("Welcome " + request.getAttribute("user") + "!");

            //is this mandatory? or truly necessary?
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");

            // print out confirmation of login message
            try (PrintWriter out = response.getWriter()) {
                out.println(" Your login was succesful! ");
            } //catch the exception here because it is view layer!!
            catch (IOException ioe) {
                System.out.println("Oeps! Something went wrong!");
                ioe.printStackTrace();
            }
            //if there is already a session active do nothing
        } else {
            //nothing
        }
    }
}
