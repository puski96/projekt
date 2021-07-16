package ro.allamvizsga.projekt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import liquibase.pro.packaged.iF;
import ro.allamvizsga.projekt.exception.ResourceNotFoundException;
import ro.allamvizsga.projekt.message.KisallatSaveMsg;
import ro.allamvizsga.projekt.message.KisallatSelectMsg;
import ro.allamvizsga.projekt.model.Fajta;
import ro.allamvizsga.projekt.model.Kisallat;
import ro.allamvizsga.projekt.model.Tulajdonos;
import ro.allamvizsga.projekt.repository.FajtaRepository;
import ro.allamvizsga.projekt.repository.KisallatRepository;
import ro.allamvizsga.projekt.service.KisallatService;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")

@RestController
@RequestMapping("/api/kisallat")
public class KisallatController {

	@Autowired
	KisallatService kisallatService;
	
	@Autowired
	KisallatRepository kisallatRepo;
	
	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERADMIN')")
	@RequestMapping(method = RequestMethod.POST, path = "/save", consumes = "application/json", produces = "application/json")
	public String mentes(@RequestBody KisallatSaveMsg kisallat) {
		kisallatService.kiment(kisallat);
		return "sikeres";
	}
	
	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERADMIN')")
	@RequestMapping(method = RequestMethod.GET, path = "/get")
 		public List<KisallatSelectMsg> test() {
 			return kisallatService.lista();
	}
	
	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERADMIN')")
	@GetMapping()
	public List<Kisallat> allatok() {
		List<Kisallat> k = kisallatRepo.findAll();
		return k;
	}
	
	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERADMIN')")
	@RequestMapping(method = RequestMethod.POST, path = "/update", consumes = "application/json", produces = "application/json")
	public String update(@RequestBody KisallatSaveMsg kisallat) {
		kisallatService.updateKisallat(kisallat);
		return "sikeres";
	}
	
	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERADMIN')")
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public Optional<Kisallat> getOne(@PathVariable Long id){
		return kisallatRepo.findById(id);
	}
	
	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERADMIN')")
	@RequestMapping(method = RequestMethod.GET, path = "/profil/{id}")
	public Optional<Kisallat> findOne(@PathVariable Long id){
		return kisallatRepo.findByTulajId(id);
	}
	
	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERADMIN')")
	@DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteKisallat(@PathVariable Long id) {
        Kisallat kisallat= kisallatRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tulajdonos not exist with id :" + id));;
        
        kisallatRepo.delete(kisallat);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
	
	@Autowired
	FajtaRepository fajtaRepository;
	
//	@RequestMapping(method = RequestMethod.GET, path = "/counter")
//	public List<Object[]> run() {
//		return kisallatRepo.countTotalKisallatokByFajtaClass();
//	}
	}
