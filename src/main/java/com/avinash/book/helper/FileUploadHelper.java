package com.avinash.book.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
//	public final String UPLOAD_DIR = "F:\\LearnCodeWithDurgesh\\Book\\src\\main\\resources\\static\\image\\";
	public final String UPLOAD_DIR = new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
	public FileUploadHelper()throws IOException {
		
	}

	public boolean uploadFile(MultipartFile file) {
		boolean f = false;
		try {
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
//			InputStream inputStream = file.getInputStream();
//			byte data[] = new byte[inputStream.available()];
//			inputStream.read(data);
//			FileOutputStream fileOutputStream = new FileOutputStream(UPLOAD_DIR+File.separator+file.getOriginalFilename());
//			fileOutputStream.write(data);
//			fileOutputStream.flush();
//			fileOutputStream.close();
			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
