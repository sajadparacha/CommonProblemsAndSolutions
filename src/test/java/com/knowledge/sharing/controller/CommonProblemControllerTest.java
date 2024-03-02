package com.knowledge.sharing.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.knowledge.sharing.domain.CommonProblem;
import com.knowledge.sharing.services.CommonProblemService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.mockito.ArgumentMatchers.*;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class CommonProblemControllerTest {
    @Mock
    CommonProblemService commonProblemService;
    @InjectMocks
    CommonProblemController commonProblemController;
    MockMvc mockMvc;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc= MockMvcBuilders.standaloneSetup(commonProblemController).build();
    }
    @Test
    void getAllCommonProblems() throws Exception {
        //given
        CommonProblem commonProblem=CommonProblem.builder().commonProblemId(1L).problemDesc("test").build();
        List<CommonProblem> commonProblemList=new ArrayList<CommonProblem>();
        commonProblemList.add(commonProblem);
        //when
        Mockito.when(commonProblemService.findAllCommonProblems()).thenReturn(commonProblemList);
        //then
        mockMvc.perform(get("/commonProblemController/allCommonProblems")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    void findCommonProblem() throws Exception {

        //given
        CommonProblem commonProblem=CommonProblem.builder().commonProblemId(1L).problemDesc("for mock test").build();
        //when
        Mockito.when(commonProblemService.findCommonProblem(anyLong())).thenReturn(commonProblem);
        //then
        mockMvc.perform(get("/commonProblemController/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                //.andExpect(jsonPath("$.problemDesc").value("for mock test"))

        ;

    }

    @Test
    void saveCommonProblem() throws Exception {

        //given
        CommonProblem commonProblem=CommonProblem.builder().commonProblemId(19L).
                problemDesc("Test for saving the data").build();

        //when
        Mockito.when(commonProblemService.saveCommonProblem(any(),anyLong())).thenReturn(commonProblem);
        //then
        mockMvc.perform(post("/commonProblemController/").
                contentType(MediaType.APPLICATION_JSON)
                .content(toJson(commonProblem))
        ).andExpect(status().isOk());
                //.andExpect(jsonPath("$.problemDesc").value("Test for saving the data"));


    }
    private String toJson(Object obj) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(obj);

    }
    @Test
    void deleteCommonProblem() throws Exception {
        //given
        //CommonProblem commonProblem=CommonProblem.builder().commonProblemId(1l)
        //when
        mockMvc.perform(delete("/commonProblemController/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        //then
    }

    @Test
    void updateCommonProblem() throws Exception {
        //given
        CommonProblem commonProblem=CommonProblem.builder().commonProblemId(1L).
                problemDesc("Test for saving the data").build();

        //when
        Mockito.when(commonProblemService.saveCommonProblem(any(),any())).thenReturn(commonProblem);
        //then
        mockMvc.perform(put("/commonProblemController/").
                contentType(MediaType.APPLICATION_JSON)
                .content(toJson(commonProblem))
        ).andExpect(status().isOk());
        //.andExpect(jsonPath("$.problemDesc").value("Test for saving the data"));

    }
}