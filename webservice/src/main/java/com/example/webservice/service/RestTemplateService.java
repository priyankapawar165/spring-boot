package com.example.webservice.service;

import com.example.webservice.entity.Post;

import java.util.List;

public interface RestTemplateService {
    public List<Post> getPost();
}
