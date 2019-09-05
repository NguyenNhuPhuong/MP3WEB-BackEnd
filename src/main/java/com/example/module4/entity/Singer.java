package com.example.module4.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Singer {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany
    private List<Song> songs;

    public Singer() {
    }

    public Singer(String name, List<Song> songs) {
        this.name = name;
        this.songs = songs;
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

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
