package com.levibrooke.codefellowship;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    AppUser author;
    String body;

    @Column(name = "created_at")
    public Date createdAt;


    public Post(String body) {
        this.body = body;
        this.createdAt = new Date();
    }

    public long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
