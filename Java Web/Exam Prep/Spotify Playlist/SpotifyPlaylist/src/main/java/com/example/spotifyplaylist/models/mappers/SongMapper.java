package com.example.spotifyplaylist.models.mappers;

import com.example.spotifyplaylist.models.Song;
import com.example.spotifyplaylist.models.dtos.CreateSongDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SongMapper {
    Song songDtoToSongEntity(CreateSongDTO createSongDTO);
}
