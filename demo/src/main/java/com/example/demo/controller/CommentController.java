package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Comment;
import com.example.demo.service.BaseService;
import com.example.demo.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController extends BaseController<Comment, Long> {

    @Autowired
    private CommentService commentService;

    @Override
    protected BaseService<Comment, Long> getService() {
        return commentService;
    }
}