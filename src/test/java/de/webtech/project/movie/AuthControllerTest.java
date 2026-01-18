package de.webtech.project.movie;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;okay

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AuthController.class)
class AuthControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    UserRepository userRepository;

    @Test
    void register_existingUsername_returnsMessage() throws Exception {
        User existing = new User("bob", "pw");
        when(userRepository.findByUsername("bob")).thenReturn(existing);

        mvc.perform(post("/auth/register")
                        .contentType("application/json")
                        .content("{\"username\":\"bob\",\"password\":\"pw\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Username already exists"));
    }

    @Test
    void login_wrongPassword_returnsMessage() throws Exception {
        User db = new User("bob", "correct");
        when(userRepository.findByUsername("bob")).thenReturn(db);

        mvc.perform(post("/auth/login")
                        .contentType("application/json")
                        .content("{\"username\":\"bob\",\"password\":\"wrong\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Wrong password"));
    }

    @Test
    void login_userNotFound_returnsMessage() throws Exception {
        when(userRepository.findByUsername("bob")).thenReturn(null);

        mvc.perform(post("/auth/login")
                        .contentType("application/json")
                        .content("{\"username\":\"bob\",\"password\":\"pw\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("User not found"));
    }
}
