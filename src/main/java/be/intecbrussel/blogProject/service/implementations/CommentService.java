package be.intecbrussel.blogProject.service.implementations;

import be.intecbrussel.blogProject.beans.CommentBean;
import be.intecbrussel.blogProject.dao.CommentDAO;
import be.intecbrussel.blogProject.service.interfaces.CommentServiceInterface;

/**
 * Represents the ServiceLayer of CommentBean class
 *
 * @author Mr. Black
 * @see CommentBean
 * @see CommentDAO
 */
public class CommentService implements CommentServiceInterface {

    // Variables
    private CommentDAO commentDAO;

    // Constructor
    public CommentService() {
        commentDAO = new CommentDAO();
    }

    // Methods
    /**
     * @see CommentDAO#safeComment(CommentBean)
     */
    @Override
    public void saveCommentToDB(CommentBean comment) {
        System.out.println("Saving Comment SERVICE");
        commentDAO.safeComment(comment);
    }
}
