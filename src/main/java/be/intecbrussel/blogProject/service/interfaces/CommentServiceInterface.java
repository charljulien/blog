package be.intecbrussel.blogProject.service.interfaces;

import be.intecbrussel.blogProject.beans.CommentBean;

public interface CommentServiceInterface {

    void saveCommentToDB(CommentBean comment);

}
