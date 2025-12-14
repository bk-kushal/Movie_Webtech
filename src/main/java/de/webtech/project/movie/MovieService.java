package de.webtech.project.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieSevice {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieSevice(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie createMovie( Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie getmovieById(long id) {
        return movieRepository.getOne(id);
    }

