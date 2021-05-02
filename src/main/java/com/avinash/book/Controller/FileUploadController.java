package com.avinash.book.Controller;

import javax.servlet.Servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.avinash.book.helper.FileUploadHelper;

@RestController
public class FileUploadController {
	
	@Autowired
	private FileUploadHelper helper;

	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
		try {
			if(file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
			}
//			if(!file.getContentType().equals("image/jpeg")) {
//				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Image type should be jpeg format");
//			}
			
			boolean f = helper.uploadFile(file);
			if(f) {
//				return ResponseEntity.ok("File upload successfully...");
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
	}
}
