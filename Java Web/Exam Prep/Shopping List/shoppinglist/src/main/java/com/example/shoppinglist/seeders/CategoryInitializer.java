package com.example.shoppinglist.seeders;

import com.example.shoppinglist.models.Category;
import com.example.shoppinglist.models.CategoryType;
import com.example.shoppinglist.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryInitializer implements CommandLineRunner {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryInitializer(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.count() == 0) {
            List<Category> categories = Arrays.stream(CategoryType.values())
                    .map(Category::new).toList();

            categoryRepository.saveAll(categories);
        }
    }
}
