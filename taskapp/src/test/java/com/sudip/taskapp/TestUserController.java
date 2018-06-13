package com.sudip.taskapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sudip.taskapp.controller.UserController;
import com.sudip.taskapp.model.User;
import com.sudip.taskapp.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.web.JsonPath;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(MockitoJUnitRunner.class)
public class TestUserController {
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserController userController;

    MockMvc mockMvc;
    ObjectMapper mapper;
    User user;

    @Before
    public void init(){
        mockMvc=MockMvcBuilders.standaloneSetup(userController).build();

        mapper=new ObjectMapper();
        user= new User(1,"sudip","admin","sudip","bolakhe");
    }

    @Test
    public void testLogin() throws Exception {
        when(userRepository.login("sudip")).thenReturn(user);
        mockMvc.perform(post("/user/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(user))).andExpect(jsonPath("$.userName",is("sudip")));

    }

    @Test
    public void testGetById() throws Exception {
        when(userRepository.getOne(1)).thenReturn(user);
        mockMvc.perform(get("/user/{id}",1)).andExpect(jsonPath("$.userName",is("sudip")));
    }
}
