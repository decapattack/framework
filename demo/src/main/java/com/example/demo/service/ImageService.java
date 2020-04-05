package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Image;
import com.example.demo.repository.ImageRepository;

@Service
public class ImageService extends BaseService<Image, Long> {
	
	 @Autowired
	 private ImageRepository imageRepository;

	@Override
	protected JpaRepository<Image, Long> getRepository() {
		// TODO Auto-generated method stub
		return imageRepository;
	}

}
