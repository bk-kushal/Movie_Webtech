package de.webtech.project.movie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Whiplash",2014));
        movies.add(new Movie("Nocturnal Animals",2016));
        movies.add(new Movie("Dune",2021));
        return movies;
    }

}
