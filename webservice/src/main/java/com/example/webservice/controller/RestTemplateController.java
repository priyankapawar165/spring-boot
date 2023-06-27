package com.example.webservice.controller;

import com.example.webservice.entity.Post;
import com.example.webservice.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class RestTemplateController {
    @Autowired
    private RestTemplateService restTemplateService;
    @GetMapping("/posts")
    public List<Post> getPosts() {
        return restTemplateService.getPost();

    }
}
