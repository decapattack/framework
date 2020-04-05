package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Post;
import com.example.demo.repository.PostRepository;

@Service
public class PostService extends BaseService<Post, Long> {
	
	@Autowired
    private PostRepository postRepository;

	@Override
	protected JpaRepository<Post, Long> getRepository() {
		// TODO Auto-generated method stub
		return postRepository;
	}

}
