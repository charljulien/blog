package be.intecbrussel.blogProject.service.interfaces;

import be.intecbrussel.blogProject.beans.CommentBean;
import be.intecbrussel.blogProject.beans.UserBean;

/**
 * CommentService Interface for CommentBean class
 *
 * @author Mr. Black
 * @see be.intecbrussel.blogProject.beans.UserBean
 * @see be.intecbrussel.blogProject.dao.UserDAO
 */
public interface CommentServiceInterface {

    /**
     * @see be.intecbrussel.blogProject.dao.UserDAO#saveUser(UserBean)
     * */
    void saveCommentToDB(CommentBean comment);
    /**
     * @see be.intecbrussel.blogProject.dao.CommentDAO#deleteComment(long)
     * */
    void deleteCommentToDB(long ig);

}
