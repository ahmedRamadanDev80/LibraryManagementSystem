package com.LibraryManagementSystem.LMS;

import com.LibraryManagementSystem.LMS.controllers.PatronController;
import com.LibraryManagementSystem.LMS.dtos.PatronDto;
import com.LibraryManagementSystem.LMS.services.PatronService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PatronController.class)
public class PatronControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatronService patronService;

    @BeforeEach
    void setUp() {
        // Setup can be done here if needed
    }

    @Test
    void testGetPatrons() throws Exception {
        PatronDto patronDto = new PatronDto(1, "John Doe", "+1234567890");
        when(patronService.getPatron()).thenReturn(Collections.singletonList(patronDto));

        mockMvc.perform(get("/api/patrons")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("John Doe"));
    }

    @Test
    void testGetPatronById() throws Exception {
        PatronDto patronDto = new PatronDto(1, "John Doe", "+1234567890");
        when(patronService.getPatronById(1)).thenReturn(patronDto);

        mockMvc.perform(get("/api/patrons/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"));
    }

    @Test
    void testUpdatePatron() throws Exception {
        PatronDto patronDto = new PatronDto(1, "Jane Doe", "+0987654321");
        doNothing().when(patronService).UpdatePatron(patronDto, 1);

        mockMvc.perform(put("/api/patrons/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Jane Doe\",\"contactInfo\":\"+0987654321\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Patron Updated"));
    }

    @Test
    void testDeletePatron() throws Exception {
        doNothing().when(patronService).DeletePatron(1);

        mockMvc.perform(delete("/api/patrons/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Patron Deleted"));
    }

    @Test
    void testAddPatron() throws Exception {
        PatronDto patronDto = new PatronDto(1, "John Doe", "+1234567890");
        doNothing().when(patronService).addPatron(patronDto);

        mockMvc.perform(post("/api/patrons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"John Doe\",\"contactInfo\":\"+1234567890\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Patron added"));
    }
}
