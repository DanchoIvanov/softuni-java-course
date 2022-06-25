package com.example.spotifyplaylist.services;

import com.example.spotifyplaylist.models.Song;
import com.example.spotifyplaylist.models.dtos.CreateSongDTO;
import com.example.spotifyplaylist.models.mappers.SongMapper;
import com.example.spotifyplaylist.repositories.SongRepository;
import com.example.spotifyplaylist.repositories.StyleRepository;
import com.example.spotifyplaylist.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    private final SongRepository songRepository;
    private final SongMapper songMapper;

    @Autowired
    public SongService(SongRepository shipRepository, SongMapper songMapper) {
        this.songRepository = shipRepository;
        this.songMapper = songMapper;
    }

    public boolean create(CreateSongDTO createSongDTO) {

        Optional<Song> byPerformer =
                this.songRepository.findByPerformer(createSongDTO.getPerformer());

        if (byPerformer.isPresent()) {
            return false;
        }

        Song song = songMapper.songDtoToSongEntity(createSongDTO);

        songRepository.save(song);

        return true;
    }
}
