package be.intecbrussel.blogProject.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * Class creates Blog Post objects
 *
 * @author Mr. Black
 * @see be.intecbrussel.blogProject.dao.BlogPostDAO
 * @see be.intecbrussel.blogProject.service.implementations.BlogPostService
 * @see be.intecbrussel.blogProject.controller.CreateBlogServlet
 * @see be.intecbrussel.blogProject.controller.AuthorPageServlet
 */
@Entity
@Table(name = "Blog_Post")
public class BlogPostBean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "Title")
    private String title;
    @Column(name = "Blog_Message")
    private String blogMessage;
    @Column(name = "Likes")
    private int likeBlogCounter;
    @Column(name = "Date")
    private LocalDate date;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "User")
    private UserBean user;
    @OneToMany(mappedBy = "blogPost", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentBean> comments;


    public BlogPostBean() {
        setDate(LocalDate.now());
    }

    public BlogPostBean(String title, String blogMessage) {
        this.title = title;
        this.blogMessage = blogMessage;
        setDate(LocalDate.now());
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getLikeBlogCounter() {
        return likeBlogCounter;
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

    public List<CommentBean> getComments() {
        return comments;
    }

    public void setComments(List<CommentBean> comments) {
        this.comments = comments;
    }

    public void addComment(CommentBean comment) {
        if (comments != null) {
            comments.add(comment);
            comment.setBlogPost(this);
        }
    }

    public String toString() {
        return getTitle() + "\n" + getBlogMessage();
    }
}
