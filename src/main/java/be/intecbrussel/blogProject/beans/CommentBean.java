package be.intecbrussel.blogProject.beans;

import java.time.LocalDate;

public class CommentBean {

    private String comment;
    private LocalDate date;

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
}
