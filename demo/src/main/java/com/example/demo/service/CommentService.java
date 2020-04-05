package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Comment;
import com.example.demo.entity.Post;
import com.example.demo.repository.CommentRepository;

@Service
public class CommentService extends BaseService<Comment, Long> {
	
	@Autowired
	private CommentRepository commentRepository;

	@Override
	protected JpaRepository<Comment, Long> getRepository() {
		// TODO Auto-generated method stub
		return commentRepository;
	}
}
