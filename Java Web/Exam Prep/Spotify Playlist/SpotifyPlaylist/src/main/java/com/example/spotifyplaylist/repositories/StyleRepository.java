package com.example.spotifyplaylist.repositories;

import com.example.spotifyplaylist.models.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleRepository extends JpaRepository<Style, Long> {
}
