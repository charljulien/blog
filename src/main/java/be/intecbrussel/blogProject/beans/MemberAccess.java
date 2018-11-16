package be.intecbrussel.blogProject.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class's object grants as a key for the access level rights of users
 * [Admin, Author, Reader]
 * //Miss Gold thinks it should be Author, User and Visitor. :P
 * //Miss Gold and Shower
 * @author Mr. Black
 * @see UserBean
 */
@Entity
@Table(name = "Member_Access")
public class MemberAccess implements Serializable {

    // Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Access_Level")
    private String memberAccessLevel;
    //Miss Gold wonders why we are keeping a list of users here.. Is it really necessary? and if yes, shouldn't we have one for author and one for user?
    @OneToMany(mappedBy = "memberAccess", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<UserBean> users;

    // Constructor
    public MemberAccess() {
        this.users = new ArrayList<>();
    }

    public MemberAccess(String memberAccessLevel) {
        this.memberAccessLevel = memberAccessLevel;
        this.users = new ArrayList<>();
    }

    // Methods
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMemberAccessLevel() {
        return memberAccessLevel;
    }

    public void setMemberAccessLevel(String memberAccessLevel) {
        this.memberAccessLevel = memberAccessLevel;
    }

    public void addMember(UserBean user) {
        if (users != null) {
            users.add(user);
            user.setMemberAccess(this);
        }
    }

    public List<UserBean> getUsers() {
        return users;
    }

    public void setUsers(List<UserBean> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return getMemberAccessLevel();
    }
}
