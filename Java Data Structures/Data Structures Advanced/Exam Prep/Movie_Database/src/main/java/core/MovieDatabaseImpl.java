package core;

import models.Movie;

import java.util.*;

public class MovieDatabaseImpl implements MovieDatabase {
    private HashMap<String, Movie> moviesByOrder = new LinkedHashMap<>();
    private Map<Integer, PriorityQueue<Movie>> moviesByYear = new TreeMap<>();

    private Comparator<Movie> ratingDescReleaseYearDesc = (t, o) -> {
        int cmp = Double.compare(o.getRating(), t.getRating());
        if (cmp == 0) {
            cmp = Integer.compare(o.getReleaseYear(), t.getReleaseYear());
        }
        return cmp;
    };

    private Comparator<Movie> ratingDesc = (t, o) -> {
        return Double.compare(o.getRating(), t.getRating());
    };


    @Override
    public void addMovie(Movie movie) {
        //void addMovie(Movie movie) – adds a movie to the MovieDatabase.
        moviesByOrder.putIfAbsent(movie.getId(), movie);

        moviesByYear.putIfAbsent(movie.getReleaseYear(), new PriorityQueue<>(ratingDesc));
        moviesByYear.get(movie.getReleaseYear()).add(movie);
    }

    @Override
    public void removeMovie(String movieId) {
        //void removeMovie(String movieId) – removes the movie with the given id.
        Movie toRemove = moviesByOrder.remove(movieId);

        if (toRemove == null) {
            throw new IllegalArgumentException();
        }

        moviesByYear.get(toRemove.getReleaseYear()).remove(toRemove);

    }

    @Override
    public int size()
    {   //int size() – returns the total count of all movies.
        return moviesByOrder.size();
    }

    @Override
    public boolean contains(Movie movie) {
        //bool contains(Movie movie) – returns whether the movie is contained inside the MovieDatabase.
        return moviesByOrder.containsKey(movie.getId());
    }

    @Override
    public Iterable<Movie> getMoviesByActor(String actorName) {
        //Iterable<Movie> getMoviesByActor(String actorName) – returns all movies,
        // which have the actor with the given name,
        // ordered by rating in descending order and by release year in descending order.
        //If there is are no movies that contain the given actor - throw IllegalArgumentException()

        List<Movie> moviesByActor = new ArrayList<>();

        for (Movie movie : moviesByOrder.values()) {
            List<String> actors = movie.getActors();
            for (String actor : actors) {
                if (actor.equals(actorName)) {
                    moviesByActor.add(movie);
                    break;
                }
            }
        }

        if (moviesByActor.isEmpty()) {
            throw new IllegalArgumentException();
        }

        moviesByActor.sort(ratingDescReleaseYearDesc);

        return moviesByActor;
    }

    @Override
    public Iterable<Movie> getMoviesByActors(List<String> actors) {
        //Iterable<Movie> getMoviesByActors(List<String> actors) – returns all movies,
        // which contain ALL  of the given actors,
        // ordered by rating in descending order and by release year in descending order.
        //If there is are no movies that contain ALL of the given actor - throw IllegalArgumentException()

        List<Movie> moviesByActors = new ArrayList<>();
        for (Movie movie : moviesByOrder.values()) {
            if (movie.getActors().containsAll(actors)) {
                moviesByActors.add(movie);
            }
        }
        if (moviesByActors.isEmpty()) {
            throw new IllegalArgumentException();
        }

        moviesByActors.sort(ratingDescReleaseYearDesc);

        return moviesByActors;
    }

    @Override
    public Iterable<Movie> getMoviesByYear(Integer releaseYear)
    {   //Iterable<Movie> getMoviesByYear(Integer year) – returns all movies,
        // which have a release year equal to the given year,
        // ordered by rating in descending order. If there aren’t any moviess – return an empty collection.
        List<Movie> result = new ArrayList<>();

        PriorityQueue<Movie> movies = new PriorityQueue<>(this.moviesByYear.get(releaseYear));

        while (!movies.isEmpty()) {
            result.add(movies.poll());
        }

        return result;
    }

    @Override
    public Iterable<Movie> getMoviesInRatingRange(double lowerBound, double upperBound) {
        //Iterable<Movie> getMoviesInRatingRange(int lowerBound, int upperBound) –
        // returns all of the movies with rating in the range specified with lower bound and upper bound.
        // Both bounds are inclusive. The results should be ordered by rating in descending order.
        // If there aren’t any mvoiess in the specified range – return an empty collection.

        List<Movie> result = new ArrayList<>();

        for (Integer year : moviesByYear.keySet()) {
            if (year > upperBound) {
                break;
            }
            if (year >= lowerBound) {
                result.addAll(this.moviesByYear.get(year));
            }
        }

        result.sort(ratingDesc);

        return result;
    }

    @Override
    public Iterable<Movie> getAllMoviesOrderedByActorPopularityThenByRatingThenByYear()
    {   //Iterable<Movie> getAllMoviesOrderedByActorPopularityThenByRatingThenByYear() –
        // returns all of the movies ordered by total amount of movies in which their actors played in descending order,
        // then by rating in desceding order and then by release year in descending order.
        // If there aren’t any movies – return an empty collection.

        Map<String, Integer> actorsRating = new HashMap<>();

        for (Movie movie : moviesByOrder.values()) {
            List<String> actors = movie.getActors();
            for (String actor : actors) {
                actorsRating.putIfAbsent(actor, 0);
                actorsRating.put(actor, actorsRating.get(actor) + 1);
            }
        }

        Comparator<Movie> orderByActorPopularityThenByRatingThenByYear = new Comparator<>() {
            @Override
            public int compare(Movie t, Movie o) {
                int cmp = Integer.compare(getActorPopularity(o), getActorPopularity(t));
                if (cmp == 0) {
                    cmp = Double.compare(o.getRating(), t.getRating());
                }
                if (cmp == 0) {
                    cmp = Integer.compare(o.getReleaseYear(), t.getReleaseYear());
                }
                return cmp;
            }

            private int getActorPopularity(Movie movie) {
                int result = 0;

                List<String> actors = movie.getActors();

                for (String actor : actors) {
                    result += actorsRating.get(actor);
                }

                return result;
            }
        };

        List<Movie> result = new ArrayList<>(moviesByOrder.values());
        result.sort(orderByActorPopularityThenByRatingThenByYear);

        return result;
    }

    //NOTE: If all sorting criteria fails, you should order by order of input. This is for all methods with ordered output.
}
