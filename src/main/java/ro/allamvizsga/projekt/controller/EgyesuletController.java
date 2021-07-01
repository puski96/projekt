package ro.allamvizsga.projekt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
import ro.allamvizsga.projekt.message.EgyesuletMsg;
import ro.allamvizsga.projekt.model.Egyesulet;
import ro.allamvizsga.projekt.model.Tulajdonos;
import ro.allamvizsga.projekt.repository.EgyesuletRepository;
import ro.allamvizsga.projekt.service.EgyesuletService;


@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/api/egyesulet")
public class EgyesuletController {

	@Autowired
	EgyesuletService egyesuletService;
	
	@Autowired
	EgyesuletRepository egyesuletRepo;
	
	
	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERADMIN')")
	@RequestMapping(method = RequestMethod.POST, path = "/save", consumes = "application/json", produces = "application/json")
	public String test2(@RequestBody Egyesulet egyesulet) {
		egyesuletService.kiment(egyesulet);
		return "sikeres";
	}
	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERADMIN')")
	@GetMapping()
	public List<Egyesulet> hello() {
		return egyesuletRepo.findAll();
	}
	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERADMIN')")
	@RequestMapping(method = RequestMethod.GET, path = "/nevek")
	public List<EgyesuletMsg> test() {
 		return egyesuletRepo.findAll().stream().map(EgyesuletMsg::new).collect(Collectors.toList());
	}
	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERADMIN')")
	@RequestMapping(method = RequestMethod.POST, path = "/update", consumes = "application/json", produces = "application/json")
	public String update(@RequestBody Egyesulet egyesulet) {
		egyesuletService.updateEgyesulet(egyesulet);
		return "sikeres";
	}
	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERADMIN')")
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public Optional<Egyesulet> getOne(@PathVariable Long id){
		return egyesuletRepo.findById(id);
	}
	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERADMIN')")
	@DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEgyesulet(@PathVariable Long id) {
        Egyesulet egyesulet= egyesuletRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tulajdonos not exist with id :" + id));;
        
        egyesuletRepo.delete(egyesulet);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
	
}
