package com.example.spotifyplaylist.controllers;

import com.example.spotifyplaylist.models.dtos.CreateSongDTO;
import com.example.spotifyplaylist.services.AuthenticationService;
import com.example.spotifyplaylist.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class SongController {
    private final SongService songService;

    private final AuthenticationService authenticationService;

    @Autowired
    public SongController(SongService songService, AuthenticationService authenticationService) {
        this.songService = songService;
        this.authenticationService = authenticationService;
    }

    @ModelAttribute("createSongDTO")
    public CreateSongDTO initCreateShipDTO() {
        return new CreateSongDTO();
    }

    @GetMapping("/song/add")
    public String ships() {
        if (!this.authenticationService.isLoggedIn()) {
            return "redirect:/";
        }

        return "song-add";
    }

    @PostMapping("/song/add")
    public String ships(@Valid CreateSongDTO createSongDTO,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

        if (!this.authenticationService.isLoggedIn()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors() || !this.songService.create(createSongDTO)) {
            redirectAttributes.addFlashAttribute("createShipDTO", createSongDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.createShipDTO", bindingResult);

            return "redirect:/song/add";
        }

        return "redirect:/home";
    }
}
