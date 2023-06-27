package com.example.webservice.controller;

import com.example.webservice.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/post")
    public Post[] getPosts() {

       ResponseEntity<Post[]> responseEntity = restTemplate
                .getForEntity("https://jsonplaceholder.typicode.com/comments", Post[].class);

        return responseEntity.getBody();
    }
}
