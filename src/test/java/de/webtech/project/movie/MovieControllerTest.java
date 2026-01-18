package de.webtech.project.movie;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MovieController.class)
class MovieControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    MovieService movieService;

    @Test
    void getMovies_withoutUsernameParam_returns400() throws Exception {
        mvc.perform(get("/movies"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getMovies_withUsername_returnsJsonList() throws Exception {
        Movie m = new Movie();
        m.setId(1L);
        m.setTitle("Test Movie");
        m.setReleaseYear(2020);
        m.setRating(4);
        m.setReview("Nice");
        m.setUsername("alice");

        when(movieService.getMoviesByUsername("alice")).thenReturn(List.of(m));

        mvc.perform(get("/movies").param("username", "alice"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Test Movie"));
    }
}
