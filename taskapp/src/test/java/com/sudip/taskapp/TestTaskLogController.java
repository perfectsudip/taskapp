package com.sudip.taskapp;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sudip.taskapp.controller.TaskLogController;
import com.sudip.taskapp.model.TaskLog;
import com.sudip.taskapp.model.User;
import com.sudip.taskapp.repository.TaskLogRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class TestTaskLogController {
    @Mock
    TaskLogRepository taskLogRepository;

    @InjectMocks
    TaskLogController taskLogController;
    ObjectMapper mapper;
    User user;
    MockMvc mockMvc;
    List<TaskLog> taskLog;
    TaskLog tl;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date d;

//@beforeClass, afterclass

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(taskLogController).build();
        user = new User(1, "abc", "mno", "xyz", "wyz");
        try {
            d = sdf.parse("21/12/2012");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mapper = new ObjectMapper();
        tl = new TaskLog(2, 200, "login", "done", d, 3, user);
        taskLog = Arrays.asList(new TaskLog(1, 200, "login", "done", d, 3, user));
    }

    @Test
    public void testGetAllTask() throws Exception {
        when(taskLogRepository.findAll()).thenReturn(taskLog);
        mockMvc.perform(get("/task/list"))
                .andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].projecttask", is("login")));
    }

    @Test
    public void testSaveTest() throws Exception {
        when(taskLogRepository.save(tl)).thenReturn(new TaskLog(2, 200, "login", "done", d, 3, user));
        mockMvc.perform(post("/task/save").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).
                content(mapper.writeValueAsString(tl))).andExpect(status().isOk()).andExpect(jsonPath("$",hasSize(1)));
    }

    @Test
    public void testGetById() throws Exception {
        when(taskLogRepository.getOne(2)).thenReturn(tl);
        mockMvc.perform(get("/task/getById/{id}", 2))
                .andExpect(jsonPath("$.id", is(2)));
    }
}