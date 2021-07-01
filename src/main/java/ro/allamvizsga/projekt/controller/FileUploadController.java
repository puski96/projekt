package ro.allamvizsga.projekt.controller;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ch.qos.logback.core.net.SyslogOutputStream;


@CrossOrigin(origins = "http://localhost:3003")
@RestController
@RequestMapping("/api/fileupload")
public class FileUploadController {
  public static String uploadDirectory = System.getProperty("user.dir","E:/probaReact/projekt")+"/uploads";
    
  
  @RequestMapping("/")
  public String UploadPage(Model model) {
	  System.out.println(uploadDirectory);
	  return "uploadview";

  }
  
	@PreAuthorize("hasRole('USER') || hasRole('ADMIN') || hasRole('SUPERUSER') || hasRole('SUPERADMIN')")
	@RequestMapping("/upload")
  public String upload(Model model,@RequestParam("files") MultipartFile[] files) {
	  System.out.println(uploadDirectory);

	  StringBuilder fileNames = new StringBuilder();
	  for (MultipartFile file : files) {
		  Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
		  try {
			Files.write(fileNameAndPath, file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }
	  model.addAttribute("msg", "Successfully uploaded files "+fileNames.toString());
	  return "uploadstatusview";
  }
  

  
}