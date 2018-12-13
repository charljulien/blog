package be.intecbrussel.blogProject.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Class creates comments
 *
 * @author Mr. Black
 * @see be.intecbrussel.blogProject.dao.CommentDAO
 * @see be.intecbrussel.blogProject.service.implementations.CommentService
 * @see be.intecbrussel.blogProject.controller.CommentServlet
 * @see be.intecbrussel.blogProject.controller.BlogLikeCounterServlet
 */
@Entity
@Table(name = "Comments")
public class CommentBean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Comment")
    private String comment;
    @Column(name = "Date")
    private LocalDate date;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "User")
    private UserBean userComment;
    @ManyToOne
    @JoinColumn(name = "Blog")
    private BlogPostBean blogPost;


    public CommentBean() {
        setDate(LocalDate.now());
    }

    public CommentBean(String comment) {
        this.comment = comment;
        setDate(LocalDate.now());
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public UserBean getUser() {
        return userComment;
    }

    public void setUser(UserBean user) {
        this.userComment = user;
    }

    public BlogPostBean getBlogPost() {
        return blogPost;
    }

    public void setBlogPost(BlogPostBean blogPost) {
        this.blogPost = blogPost;
    }

    @Override
    public String toString() {
        return "CommentBean{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                '}';
    }
}
