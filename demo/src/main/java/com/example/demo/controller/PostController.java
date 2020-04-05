package com.example.demo.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.Comment;
import com.example.demo.entity.Post;
import com.example.demo.service.BaseService;
import com.example.demo.service.CommentService;
import com.example.demo.service.PostService;
import com.sun.xml.bind.v2.model.core.ID;

@RestController
@RequestMapping("/posts")
public class PostController extends BaseController<Post, Long> {

    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;
    

    @Override
    protected BaseService<Post, Long> getService() {
        return postService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/postComComentarios/{id}")
    public Post postComComentarios(@PathVariable("id") Long id){
    	Post post = postService.search(id);
    	List<Comment> comentarioPost = new ArrayList<Comment>();
    	List<Comment> comentarios = commentService.list();
    	for(Comment comentario : comentarios) {
    		if(comentario.getPostId() == id) {
    			comentarioPost.add(comentario);
    		}
    	}
    	post.setComentarios(comentarioPost);
    	return post;
    }
}
