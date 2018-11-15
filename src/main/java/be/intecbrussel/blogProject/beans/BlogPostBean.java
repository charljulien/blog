package be.intecbrussel.blogProject.beans;

import javax.persistence.*;
import java.io.Serializable;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Class creates Blog Post objects
 *
 * @author Mr. Black
 * @see be.intecbrussel.blogProject.dao.BlogPostDAO
 */
@Entity
@Table(name = "Blog_Post")
public class BlogPostBean implements Serializable {

    // Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "Blog_Message")
    private String blogMessage;
    @Column(name = "Likes")
    private int likeBlogCounter;
    @Column(name = "Date")
    private LocalDate date;
    @ManyToOne
    @Column(name = "User")
    private UserBean user;

    // Constructor
    public BlogPostBean() {
        setDate(LocalDate.now());
    }

    public BlogPostBean(String blogMessage) {
        this.blogMessage = blogMessage;
        setDate(LocalDate.now());
    }
    // Methods

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBlogMessage() {
        return blogMessage;
    }

    public void setBlogMessage(String blogMessage) {
        this.blogMessage = blogMessage;
    }

    public int likeIncrease() {
        return likeBlogCounter++;
    }

    public int likeDecrease() {
        return likeBlogCounter--;
    }

    public int getLikeBlogCounter() {
        return likeBlogCounter;
    }

    public void setLikeBlogCounter(int likeBlogCounter) {
        this.likeBlogCounter = likeBlogCounter;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }
}
