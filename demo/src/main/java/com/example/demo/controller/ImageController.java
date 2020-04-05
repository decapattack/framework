package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Image;
import com.example.demo.service.BaseService;
import com.example.demo.service.ImageService;

@RestController
@RequestMapping("/image")
public class ImageController extends BaseController<Image, Long> {

    @Autowired
    private ImageService imageService;
    

    @Override
    protected BaseService<Image, Long> getService() {
        return imageService;
    }
    
    

}
