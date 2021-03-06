package be.intecbrussel.blogProject.service.implementations;

import be.intecbrussel.blogProject.beans.BlogPostBean;
import be.intecbrussel.blogProject.beans.CommentBean;
import be.intecbrussel.blogProject.beans.UserBean;
import be.intecbrussel.blogProject.dao.CommentDAO;
import be.intecbrussel.blogProject.service.interfaces.CommentServiceInterface;

import java.util.List;

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
     * @see CommentDAO#saveComment(CommentBean)
     */
    @Override
    public void saveCommentToDB(CommentBean comment, UserBean user) {
        System.out.println("Saving Comment SERVICE...");
        comment.setUser(user);
        commentDAO.saveComment(comment);
    }

    // TRIAL VERSION Mr. Black
    @Override
    public void saveCommentToDB(CommentBean comment, UserBean user, BlogPostBean blog) {
        System.out.println("Saving Comment to certain blog on article page.. SERVICE");
        user.addComment(comment);
        blog.addComment(comment);
        commentDAO.saveComment(comment);
    }

    @Override
    public void deleteCommentToDB(long id) {
        System.out.println("Deleting Comment SERVICE...");
        commentDAO.deleteComment(id);
    }

    @Override
    public List<CommentBean> readAllComments() {
        return commentDAO.getAllComments();
    }
}
