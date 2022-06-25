package com.example.spotifyplaylist.repositories;

import com.example.spotifyplaylist.models.Song;
import com.example.spotifyplaylist.models.StyleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    Optional<Song> findByPerformer(String performer);

    Set<Song> findByStyle(StyleType type);
}
