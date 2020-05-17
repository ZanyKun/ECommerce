package com.b13.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.b13.dto.Product;
import com.b13.service.ProductService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ProductController.class)
public class ProductControllerTest {

    @Autowired
    MockMvc mvc;
    @MockBean ProductService service;
    @Mock Product prod;

    @Test
    void insertNewProductBasicFlow() throws Exception {
        when(service.createProduct(prod)).thenReturn(Optional.of(new Product()));
    	mvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
    @Test
    void insertNewProductBasicFlow2() throws Exception {
        when(service.createProduct(prod)).thenReturn(Optional.empty());
    	mvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
    
    @Test
    public void getProductById() throws Exception {
    	when(service.getProductById(Mockito.anyString())).thenReturn(Optional.of(new Product()));
    	mvc.perform(get("/products/1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
    
    @Test
    public void getProductById2() throws Exception {
    	when(service.getProductById(Mockito.anyString())).thenReturn(Optional.empty());
    	mvc.perform(get("/products/1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
    }
    
    @Test
    public void deleteProductById() throws Exception {
    	when(service.deleteProductById(Mockito.anyString())).thenReturn(Optional.of(new Product()));
    	mvc.perform(delete("/products/1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
    
    @Test
    public void deleteProductById2() throws Exception {
    	when(service.deleteProductById(Mockito.anyString())).thenReturn(Optional.empty());
    	mvc.perform(delete("/products/1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
    }
    
    @Test
    public void updateProductById() throws Exception {
    	when(service.updateProduct(prod)).thenReturn(Optional.of(new Product()));
    	mvc.perform(put("/products/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
    } // put is failing, don't really know why or if i'm testing it right
    
    
    
}
