package com.restapi.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
public class Customer {
    @Id
    @GeneratedValue
    int id;
    String name;


    @OneToMany(mappedBy = "customer")
    //@JsonIgnore
    List<Post> posts;

    public Customer() {
    }

    public Customer(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
