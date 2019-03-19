package edu.mum.tmAttendanceReport.dto;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadInfo {
	
     // Upload file
     private MultipartFile file;
  
     public MultipartFile getFile() {
         return file;
     }
  
     public void setFile(MultipartFile fileDatas) {
         this.file = fileDatas;
     }
}
