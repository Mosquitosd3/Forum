package ru.job4j.forum.control;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class GetControlTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/index"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageTopic() throws Exception {
        this.mockMvc.perform(get("/topic/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("forum/topic"));
    }

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessagePost() throws Exception {
        this.mockMvc.perform(get("/post/3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("forum/post"));
    }

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageCreate() throws Exception {
        this.mockMvc.perform(get("/create"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("forum/create"));
    }

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageEdit() throws Exception {
        this.mockMvc.perform(get("/edit/3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("forum/edit"));
    }

}