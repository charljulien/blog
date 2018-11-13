package be.intecbrussel.blogProject.service.implementations;

import be.intecbrussel.blogProject.beans.CommentBean;
import be.intecbrussel.blogProject.dao.CommentDAO;
import be.intecbrussel.blogProject.service.interfaces.CommentServiceInterface;

public class CommentService implements CommentServiceInterface {

    // Variables
    private CommentDAO commentDAO;

    // Constructor
    public CommentService(){
        commentDAO = new CommentDAO();
    }

    // Methods
    @Override
    public void saveCommentToDB(CommentBean comment) {
        System.out.println("Saving Comment SERVICE");
        commentDAO.safeComment(comment);
    }
}
