package com.example.spotifyplaylist.models.dtos;

import com.example.spotifyplaylist.models.Style;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class CreateSongDTO {

    @NotBlank()
    @Size(min = 3, max = 20)
    private String performer;

    @NotBlank()
    @Size(min = 2, max = 20)
    private String title;

    @Positive
    private int duration;

    @PastOrPresent
    private LocalDate releaseDAte;

    @NotBlank()
    private Style style;

    public CreateSongDTO() {
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getReleaseDAte() {
        return releaseDAte;
    }

    public void setReleaseDAte(LocalDate releaseDAte) {
        this.releaseDAte = releaseDAte;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }
}
