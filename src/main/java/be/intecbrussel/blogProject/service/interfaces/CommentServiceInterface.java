package be.intecbrussel.blogProject.service.interfaces;

import be.intecbrussel.blogProject.beans.BlogPostBean;
import be.intecbrussel.blogProject.beans.CommentBean;
import be.intecbrussel.blogProject.beans.UserBean;

import java.util.List;

/**
 * CommentService Interface for CommentBean class
 *
 * @author Mr. Black
 * @see be.intecbrussel.blogProject.beans.UserBean
 * @see be.intecbrussel.blogProject.dao.UserDAO
 */
public interface CommentServiceInterface {

    /**
     * @see be.intecbrussel.blogProject.dao.CommentDAO#saveComment(CommentBean)
     */
    void saveCommentToDB(CommentBean comment, UserBean user);

     void saveCommentToDB(CommentBean comment, UserBean user, BlogPostBean blog);

    /**
     * @see be.intecbrussel.blogProject.dao.CommentDAO#deleteComment(long)
     */
    void deleteCommentToDB(long ig);

    List<CommentBean> readAllComments();

}
