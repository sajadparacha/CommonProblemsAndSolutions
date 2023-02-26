package com.knowledge.sharing.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.knowledge.sharing.domain.Application;
import com.knowledge.sharing.services.ApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;

class ApplicationControllerTest {
    @Mock
    ApplicationService applicationService;
    @InjectMocks
    ApplicationController applicationController;
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc= MockMvcBuilders.standaloneSetup(applicationController).build();
    }

    @Test
    void getAllApplications() throws Exception {
        //Given
        Application application=Application.builder().applicationId(1l)
                .applName("SAIRO").build();
        List<Application> applicationList=new ArrayList<Application>();
        applicationList.add(application);
        //When
        Mockito.when(applicationService.findAllApplications()).thenReturn(applicationList);
        //Then
        mockMvc.perform(MockMvcRequestBuilders.get("/applicationController/allApplications").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                ;


    }

    @Test
    void findApplication() throws Exception {
        //Given
        Application application=Application.builder().applicationId(1l)
                .applName("SAIRO").build();
        //When
        Mockito.when(applicationService.findApplication(ArgumentMatchers.anyLong())).thenReturn(application);
        //Then
        mockMvc.perform(MockMvcRequestBuilders.get("/applicationController/1").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.applName").value("SAIRO"));

    }

    @Test
    void saveApplication() throws Exception {
        //Given
        Application application=Application.builder().applicationId(1l)
                .applName("SAIRO").build();
        //When
        //Mockito.when(applicationService.saveApplication(any())).thenReturn(application);



        //Then
        mockMvc.perform(MockMvcRequestBuilders.post("/applicationController")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(application))
                ).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void deleteApplication() throws Exception {
         //When
        //Mockito.when(applicationService.saveApplication(any())).thenReturn(application);



        //Then
        mockMvc.perform(MockMvcRequestBuilders.delete("/applicationController/1")
                .contentType(MediaType.APPLICATION_JSON)

        ).andExpect(MockMvcResultMatchers.status().isOk());


    }

    @Test
    void updateApplication() throws Exception {
        //Given
        Application application=Application.builder().applicationId(1l)
                .applName("SAIRO").build();
        //When
        //Mockito.when(applicationService.saveApplication(any())).thenReturn(application);



        //Then
        mockMvc.perform(MockMvcRequestBuilders.put("/applicationController")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(application))
        ).andExpect(MockMvcResultMatchers.status().isOk());


    }
    private String toJson(Object obj) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(obj);

    }

}