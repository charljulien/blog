package be.intecbrussel.blogProject.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User_Blog")
public class UserBean implements Serializable {

    // Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "FirstName")
    private String firstname;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "UserName")
    private String userName;
    @Column(name = "Email")
    private String email;
    @Column(name = "Street")
    private String street;
    @Column(name = "House_no")
    private String houseNr;
    @Column(name = "City")
    private String city;
    @Column(name = "Zip")
    private String zipCode;
    @Column(name = "Password")
    private String password;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AccessRight")
    private MemberAccess memberAccess;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BlogPostBean> blogs;
    @OneToMany(mappedBy = "userComment",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentBean> comments;

    // Constructor
    public UserBean() {
        this.blogs = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public UserBean(String firstname, String lastName, String userName,
                    String email, String street, String houseNr, String city,
                    String zipCode, String password) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.street = street;
        this.houseNr = houseNr;
        this.city = city;
        this.zipCode = zipCode;
        this.password = password;
        this.blogs = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    // Methods
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNr() {
        return houseNr;
    }

    public void setHouseNr(String houseNr) {
        this.houseNr = houseNr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MemberAccess getMemberAccess() {
        return memberAccess;
    }

    public void setMemberAccess(MemberAccess memberAccess) {
        this.memberAccess = memberAccess;
    }

    public void addBlog(BlogPostBean blog){
        if(blogs != null){
            blogs.add(blog);
            blog.setUser(this);
        }
    }

    public List<BlogPostBean> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<BlogPostBean> blogs) {
        this.blogs = blogs;
    }

    public void addComment(CommentBean comment){
        if(comments != null){
            comments.add(comment);
            comment.setUser(this);
        }
    }

    public List<CommentBean> getComments() {
        return comments;
    }

    public void setComments(List<CommentBean> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", name='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", street='" + street + '\'' +
                ", houseNr=" + houseNr +
                ", city='" + city + '\'' +
                ", zipCode=" + zipCode +
                ", password='" + password + '\'' +
                '}';
    }
}
