package com.upload.file.uploadingfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.upload.file.uploadingfile.properties.FileStorageProperty;

@SpringBootApplication
@EnableConfigurationProperties({
	FileStorageProperty.class
})
public class UploadingFileApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploadingFileApplication.class, args);
	}

}
