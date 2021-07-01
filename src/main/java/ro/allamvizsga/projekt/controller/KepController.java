package ro.allamvizsga.projekt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.annotation.JsonView;

import liquibase.pro.packaged.iF;
import ro.allamvizsga.projekt.model.Hirdetesek;
import ro.allamvizsga.projekt.model.Kepfeltolt;
import ro.allamvizsga.projekt.model.View;
import ro.allamvizsga.projekt.repository.HirdetesekRepository;
import ro.allamvizsga.projekt.repository.KepRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class KepController {
	@Autowired
	KepRepository kepRepository;

	/*
	 * List All Files
	 */
    @JsonView(View.FileInfo.class)
	@GetMapping("/api/file/all")
	public List<Kepfeltolt> getListFiles() {
		return kepRepository.findAllByOrderByIdDesc();
		
	}
	
    /*
     * Download Files
     */
	@GetMapping("/api/file/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
		Optional<Kepfeltolt> fileOptional = kepRepository.findById(id);
		
		if(fileOptional.isPresent()) {
			Kepfeltolt file = fileOptional.get();
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
					.body(file.getPic());	
		}
		
		return ResponseEntity.status(404).body(null);
	}
	
	@Autowired
	HirdetesekRepository hirdetesekRepository;
	
	@PreAuthorize("hasRole('USER') || hasRole('ADMIN') || hasRole('SUPERUSER') || hasRole('SUPERADMIN')")
    @PostMapping("/api/file/upload/{id}")
    public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file, @PathVariable Long id) {
    	try {
    		Hirdetesek hirdetesek=hirdetesekRepository.getOne(id);
    		// save file to PostgreSQL
    		
    		Kepfeltolt dbImage = new Kepfeltolt();
            
            	dbImage.setHirdetesek(hirdetesek);
	            dbImage.setName(file.getName());
	            dbImage.setPic(file.getBytes());
	            dbImage.setMimetype("image/jpeg");
           
	    	kepRepository.save(dbImage);
	    	return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
		} catch (	Exception e) {
			return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
		}    
    }
	
	@PreAuthorize("hasRole('USER') || hasRole('ADMIN') || hasRole('SUPERUSER') || hasRole('SUPERADMIN')")
    @PostMapping("api/upload")
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {

    	kepRepository.save(file);
		redirectAttributes.addFlashAttribute("message",
				"You successfully uploaded " + file.getOriginalFilename() + "!");

		return "redirect:/";
	}

	@PreAuthorize("hasRole('USER') || hasRole('ADMIN') || hasRole('SUPERUSER') || hasRole('SUPERADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteKep(@PathVariable Long id) {
        Kepfeltolt kepfeltolt = kepRepository.findById(id).get();
        
        kepRepository.delete(kepfeltolt);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
