package de.webtech.project.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie createMovie( Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie getMovieById(long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public void deleteMovie(Long id){
    movieRepository.deleteById(id);
    }
}

