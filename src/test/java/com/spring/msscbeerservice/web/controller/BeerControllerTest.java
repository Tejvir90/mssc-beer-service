package com.spring.msscbeerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.msscbeerservice.web.model.BeerDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    UUID uuid;

    @BeforeEach
    public void setup() {
        uuid = UUID.randomUUID();
    }

    @Test
    void getBeer() throws Exception {


        mockMvc.perform(get("/api/v1/beer/" + uuid).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(uuid.toString()));
    }

    @Test
    void saveNewBeer() throws Exception {

        BeerDto beerDto = BeerDto.builder().build();

        mockMvc.perform(post("/api/v1/beer").content(objectMapper.writeValueAsBytes(beerDto))
                .accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isCreated());


    }

    @Test
    void updateBeer() throws Exception  {
        BeerDto beerDto = BeerDto.builder().build();

        mockMvc.perform(put("/api/v1/beer/"+ uuid).content(objectMapper.writeValueAsBytes(beerDto))
                .accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isNoContent());
    }


    @Test
    void deleteBeerByID() throws Exception{
        mockMvc.perform(delete("/api/v1/beer/"+ uuid).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }


}