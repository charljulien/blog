package be.intecbrussel.blogProject.beans;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "Comments")
public class CommentBean {

    // Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Comment")
    private String comment;
    @Column(name = "Date")
    private LocalDate date;

    // Constructor
    public CommentBean() {
    }

    public CommentBean(String comment){
        this.comment = comment;
       setDate(LocalDate.now());
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

    @Override
    public String toString() {
        return "CommentBean{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                '}';
    }
}
