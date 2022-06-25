package com.example.spotifyplaylist.models;

import javax.persistence.*;

@Entity
@Table(name = "styles")
public class Style {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false, name = "style_name")
    @Enumerated(value = EnumType.STRING)
    private StyleType styleName;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Style() {
    }

    public Style(StyleType styleName) {
        this.styleName = styleName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public StyleType getStyleName() {
        return styleName;
    }

    public void setStyleName(StyleType styleName) {
        this.styleName = styleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
