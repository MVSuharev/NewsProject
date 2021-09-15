package com.example.newsproject.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_News")
public class News {
    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "Title", length = 255, nullable = false)
    private String title;

    @Column(name = "Body", nullable = false)
    private String body;

    @Column(name = "Author", length = 255, nullable = false)
    private String author;

    @Temporal(TemporalType.DATE)
    @Column(name = "Creation", nullable = false)
    private Date creation;

    public News() {}
    public News(String title, String body, String author, Date creation) {
        this.title = title;
        this.body = body;
        this.author = author;
        this.creation = creation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }
}
