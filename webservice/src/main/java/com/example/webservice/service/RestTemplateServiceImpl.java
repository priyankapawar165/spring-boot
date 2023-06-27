package com.example.webservice.service;

import com.example.webservice.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Post> getPost() {
        ResponseEntity<Post[]> responseEntity = restTemplate
                .getForEntity("https://jsonplaceholder.typicode.com/comments", Post[].class);
        return List.of(responseEntity.getBody());
    }
}
