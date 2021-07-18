package com.nagp.java_userapp;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserController.class)
public class UserControllerTest {
	
	 @Autowired
	 MockMvc mockMvc;
	 @Autowired
	 ObjectMapper mapper;
	 

	 @MockBean
	 UserInterfaceImpl userInterface;
	 
	 @Test
	 public void getAllUsers_return_valid_response() throws Exception {
		 UserModel user = new UserModel(1L, "Santosh Khanna", "Hisar");
		 List<UserModel> users = new ArrayList<UserModel>(Arrays.asList(user));
		 
		 Mockito.when(userInterface.getAllUsers()).thenReturn(users);
		 
		 mockMvc.perform(MockMvcRequestBuilders
		            .get("/user/getallusers")
		            .contentType(MediaType.APPLICATION_JSON))
		            .andExpect(status().isOk());
	 }

}
