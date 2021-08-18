package com.testprimeno.primeno.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(PrimeNumController.class)
public class PrimeNumControllerTest {
	@Autowired
    MockMvc mockMvc;
	
	
	@Test
	public void getAllRecords_success() throws Exception {
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/primeNumbers/4")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", hasSize(3)))
	            .andExpect(jsonPath("$[2].name", is("Jane Doe")));
	}
}
