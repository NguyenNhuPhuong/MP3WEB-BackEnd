package com.example.module4.service;

import com.example.module4.entity.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {
    List<Song> findAll();

    Optional<Song> findById(Long id);

    void save(Song song);

    void remove(Long id);
}
