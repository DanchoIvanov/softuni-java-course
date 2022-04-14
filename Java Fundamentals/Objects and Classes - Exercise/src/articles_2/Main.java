package articles_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Article> articles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String title = input.split(", ")[0];
            String content = input.split(", ")[1];
            String author = input.split(", ")[2];
            Article article = new Article(title, content, author);
            articles.add(article);
        }
        String criteria = scanner.nextLine();
        switch (criteria){
            case "title" :
                articles.stream()
                        .sorted(Comparator.comparing(Article::getTitle))
                        .forEach(System.out::println);
                break;
            case "content" :
                articles.stream()
                        .sorted(Comparator.comparing(Article::getContent))
                        .forEach(System.out::println);
                break;
            case "author" :
                articles.stream()
                        .sorted(Comparator.comparing(Article::getAuthor))
                        .forEach(System.out::println);
                break;
        }
    }
}