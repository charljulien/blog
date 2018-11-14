package be.intecbrussel.blogProject.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Comments")
public class CommentBean implements Serializable {

    // Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Comment")
    private String comment;
    @Column(name = "Date")
    private LocalDate date;
    @ManyToOne
    @Column(name = "User_Comment")
    private UserBean userComment;

    // Constructor
    public CommentBean() {
        setDate(LocalDate.now());
    }

    public CommentBean(String comment) {
        this.comment = comment;
        setDate(LocalDate.now());
    }

    // Methods
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

    @Override
    public String toString() {
        return "CommentBean{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                '}';
    }
}
