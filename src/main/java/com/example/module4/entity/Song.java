package com.example.module4.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Song {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String typesong;

    @ManyToOne
    private Compose compose;

    @ManyToMany
    private List<Singer> singer;

    public Song() {
    }

    public Song(String name, String typesong, Compose compose, List<Singer> singer) {
        this.name = name;
        this.typesong = typesong;
        this.compose = compose;
        this.singer = singer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypesong() {
        return typesong;
    }

    public void setTypesong(String typesong) {
        this.typesong = typesong;
    }

    public Compose getCompose() {
        return compose;
    }

    public void setCompose(Compose compose) {
        this.compose = compose;
    }

    public List<Singer> getSinger() {
        return singer;
    }

    public void setSinger(List<Singer> singer) {
        this.singer = singer;
    }
}
