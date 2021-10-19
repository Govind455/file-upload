package com.upload.file.uploadingfile.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.upload.file.uploadingfile.exception.FileStorageException;

@Service
public class UploadService {

	private Path fileStorageLocation ;
	
	public  String storeFile(MultipartFile file) {
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		try {
			
			if(fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence"+fileName );
			}
			
			Path targetLocation = this.fileStorageLocation.resolve(fileName);
			Files.copy(file.getInputStream(), targetLocation,StandardCopyOption.REPLACE_EXISTING);
			
			return fileName;
		}
		catch(IOException ex) {
			throw new FileStorageException("Could not Store File"+fileName+"Please try again !",ex);
		}
	}

}
