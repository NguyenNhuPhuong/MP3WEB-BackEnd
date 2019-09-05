package com.example.module4.repository;

import com.example.module4.entity.Song;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface SongRepository extends PagingAndSortingRepository<Song, Long> {

}
