package ro.allamvizsga.projekt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ro.allamvizsga.projekt.exception.ResourceNotFoundException;
import ro.allamvizsga.projekt.model.Egyesulet;
import ro.allamvizsga.projekt.model.Hirdetesek;
import ro.allamvizsga.projekt.model.Keres;
import ro.allamvizsga.projekt.repository.KeresRepository;
import ro.allamvizsga.projekt.service.KeresService;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/api/keres")
public class KeresController {

	@Autowired
	KeresService keresService;
	
	@Autowired
	KeresRepository keresRepo;
	
	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERUSER') || hasRole('SUPERADMIN')")
	@RequestMapping(method = RequestMethod.POST, path = "/save", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String test2(@RequestBody Keres keres) {
		keresService.kiment(keres);
		return "sikeres";
	}
	
	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERADMIN')")
	@GetMapping()
	public List<Keres> lista() {
		return keresRepo.findAll();
	}
	
	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERADMIN')")
	@RequestMapping(method = RequestMethod.GET, path = "/find/{id}")
	public Optional<Keres> getOne(@PathVariable Long id){
		return keresRepo.findById(id);
	}
	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERADMIN')")
	@RequestMapping(method = RequestMethod.GET, path = "/kereseim/{id}")
	public List<Keres> findKeresek(@PathVariable Long id){
		return keresRepo.findAllByTulajdonosId(id);
	}

	
	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERADMIN')")
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteKeres(@PathVariable Long id) {
        Keres keres= keresRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tulajdonos not exist with id :" + id));;
        
        keresRepo.delete(keres);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
