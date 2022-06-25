package com.example.spotifyplaylist.controllers;

import com.example.spotifyplaylist.models.Song;
import com.example.spotifyplaylist.models.StyleType;
import com.example.spotifyplaylist.models.User;
import com.example.spotifyplaylist.models.dtos.CreateSongDTO;
import com.example.spotifyplaylist.repositories.SongRepository;
import com.example.spotifyplaylist.repositories.UserRepository;
import com.example.spotifyplaylist.services.AuthenticationService;
import com.example.spotifyplaylist.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Set;

@Controller
public class HomeController {

    private final SongService songService;

    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;
    private final SongRepository songRepository;

    @Autowired
    public HomeController(SongService songService, AuthenticationService authenticationService, UserRepository userRepository, SongRepository songRepository) {
        this.songService = songService;
        this.authenticationService = authenticationService;
        this.userRepository = userRepository;
        this.songRepository = songRepository;
    }


    @ModelAttribute("createSongDTO")
    public CreateSongDTO initBattleForm() {
        return new CreateSongDTO();
    }



    @GetMapping("/")
    public String loggedOutIndex() {
        if (this.authenticationService.isLoggedIn()) {
            return "redirect:/home";
        }

        return "index";
    }

    @GetMapping("/home")
    public String loggedInIndex(Model model) {
        if (!this.authenticationService.isLoggedIn()) {
            return "redirect:/";
        }

        long loggedUserId = this.authenticationService.getLoggedUserId();

        User user = userRepository.getById(loggedUserId);
        Set<Song> ownedSongs = user.getSongs();
        Set<Song> jazzSongs = songRepository.findByStyle(StyleType.JAZZ);
        Set<Song> rockSongs = songRepository.findByStyle(StyleType.ROCK);
        Set<Song> popSongs = songRepository.findByStyle(StyleType.POP);

        model.addAttribute("ownedSongs", ownedSongs);
        model.addAttribute("jazzSongs", jazzSongs);
        model.addAttribute("rockSongs", rockSongs);
        model.addAttribute("popSongs", popSongs);

        return "home";
    }
}
