package com.example.spotifyplaylist.seeders;

import com.example.spotifyplaylist.models.Style;
import com.example.spotifyplaylist.models.StyleType;
import com.example.spotifyplaylist.repositories.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class StyleInitializer implements CommandLineRunner {
    private StyleRepository styleRepository;

    @Autowired
    public StyleInitializer(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (styleRepository.count() == 0) {
            List<Style> styles = Arrays.stream(StyleType.values())
                    .map(Style::new).toList();

            styleRepository.saveAll(styles);
        }
    }
}