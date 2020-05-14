package com.b13.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ProductControllerTest.class)
public class ProductControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    void insertNewProductBasicFlow() throws Exception {
        mvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}
