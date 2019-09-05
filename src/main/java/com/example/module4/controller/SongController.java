package com.example.module4.controller;


import com.example.module4.entity.Song;
import com.example.module4.entity.User;
import com.example.module4.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;


@RestController
public class SongController {

    @Autowired
    private SongService songService;

    @RequestMapping(value = "/song/", method = RequestMethod.GET)
    public ResponseEntity<List<Song>> listResponseEntity() {
        List<Song> songs = songService.findAll();
        if (songs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @RequestMapping(value = "/song/", method = RequestMethod.POST)
    public ResponseEntity<Void> createSong(@RequestBody Song song, UriComponentsBuilder ucBuilder) {
        songService.save(song);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/song/{id}").buildAndExpand(song.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    Song song1 = null;

    @RequestMapping(value = "/song/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Song> updateCustomer(@PathVariable("id") long id, @RequestBody Song song) {
        Optional<Song> currentSong = songService.findById(id);
        currentSong.ifPresent(item -> song1 = item);
        if (currentSong.isPresent()) {
            song1.setCompose(song.getCompose());
            song1.setName(song.getName());
            song1.setSinger(song.getSinger());
            song1.setTypesong(song.getTypesong());
            return new ResponseEntity<>(song1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
