package com.upload.file.uploadingfile.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.upload.file.uploadingfile.payload.FileUploadResponse;
import com.upload.file.uploadingfile.service.UploadService;

@RestController
public class UploadController {
	
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	@Autowired
	private UploadService uploadService;
	
	@PostMapping("/uploadfile")
	public FileUploadResponse uploadFile(@RequestParam("file")	MultipartFile file) {
		String fileName = uploadService.storeFile(file);
		
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/downloadFile/")
				.path(fileName)
				.toString();
		return new FileUploadResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
	}

	
}
