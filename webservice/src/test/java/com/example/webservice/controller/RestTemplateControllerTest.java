package com.example.webservice.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.webservice.entity.Post;
import com.example.webservice.service.RestTemplateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(RestTemplateController.class)
public class RestTemplateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestTemplateService service;

    @MockBean
    private RestTemplate restTemplate;

    @Test
    public void postShouldReturnListFromService() throws Exception {

        List<Post> postList = new ArrayList<>();
        Post post = new Post();
        post.setBody("Test");
        post.setPostId(1);
        post.setEmail("test@123");
        postList.add(post);

        when(service.getPost()).thenReturn(postList);

        MvcResult mvcResult = this.mockMvc.perform(get("/posts")).andDo(print()).andExpect(status().isOk()).andReturn();

    }
}