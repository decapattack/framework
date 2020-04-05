package com.example.demo.controller;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.BaseEntity;
import com.example.demo.entity.Image;
import com.example.demo.repository.ImageRepository;
import com.example.demo.service.BaseService;
import com.example.demo.service.ImageService;

public abstract class BaseController  <T extends BaseEntity<ID>, ID extends Serializable> {
	
	protected abstract BaseService<T, ID> getService();
	
	@Autowired
	ImageService imageService;
	
	
	@CrossOrigin(origins = "*")
    @GetMapping("/all")
    public ResponseEntity<List<T>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(getService().list());
    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> save(@Valid @RequestBody T entity) {
    	entity.getClass();
        entity = getService().save(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<?> search(@PathVariable("id") ID id) {
        T entidade = getService().search(id);
        return ResponseEntity.status(HttpStatus.OK).body(entidade);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") ID id) {
        getService().delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @CrossOrigin(origins = "*")
    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@RequestBody T entity, @PathVariable("id") ID id) {
        entity.setId(id);
        getService().update(entity);
        return ResponseEntity.noContent().build();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/upload")
	public ResponseEntity<?> uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException{
    	System.out.println("Original Image Byte Size - " + file.getBytes().length);
    	Image image = new Image();
    	image.setImagem(file.getBytes());
    	image.setNome(file.getOriginalFilename());
    	image.setUser(1L);
    	imageService.save(image);
    	return ResponseEntity.status(HttpStatus.OK).body(file);
    }

}
