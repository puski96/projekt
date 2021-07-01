package ro.allamvizsga.projekt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ro.allamvizsga.projekt.message.HirdetesekMsg;
import ro.allamvizsga.projekt.message.HirdetesekSaveMsg;
import ro.allamvizsga.projekt.model.Hirdetesek;
import ro.allamvizsga.projekt.model.Kisallat;
import ro.allamvizsga.projekt.repository.HirdetesekRepository;
import ro.allamvizsga.projekt.service.HirdetesekService;

@CrossOrigin(origins = "http://localhost:3003")
@RestController
@RequestMapping("/api/hirdetesek")
public class HirdetesekController {

	@Autowired
	HirdetesekService hirdetesekService;
	
	@Autowired
	HirdetesekRepository hirdetesekRepository;
	
	@PreAuthorize("hasRole('USER') || hasRole('ADMIN') || hasRole('SUPERUSER') || hasRole('SUPERADMIN')")
	@RequestMapping(method = RequestMethod.POST, path = "/test", consumes = "application/json", produces = "application/json")
	public void mentes(@RequestBody HirdetesekSaveMsg hirdetesek) {
		hirdetesekService.kiment(hirdetesek);
		System.out.println(hirdetesek);
	}
	
	
	@PreAuthorize("hasRole('USER') || hasRole('ADMIN') || hasRole('SUPERUSER') || hasRole('SUPERADMIN')")
	@GetMapping()
	public List<Hirdetesek> hirdetesek() {
		return hirdetesekRepository.findAll();
				}
	
	@RequestMapping(method = RequestMethod.GET, path = "/counter")
	public List<Object> count(){
		System.out.println(hirdetesekRepository.countTotalHirdetesekByEladva());
		return hirdetesekRepository.countTotalHirdetesekByEladva();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/get")
	public List<HirdetesekMsg> test() {
 		return hirdetesekRepository.findAll().stream().map(HirdetesekMsg::new).collect(Collectors.toList());
	}
	@PreAuthorize("hasRole('USER') || hasRole('ADMIN') || hasRole('SUPERUSER') || hasRole('SUPERADMIN')")
	@RequestMapping(method = RequestMethod.GET, path = "/hirdeteseim/{id}")
	public List<Hirdetesek> findOne(@PathVariable Long id){
		return hirdetesekRepository.findAllByTulajdonosId(id);
	}
	
	@PreAuthorize("hasRole('USER') || hasRole('ADMIN') || hasRole('SUPERUSER') || hasRole('SUPERADMIN')")
	@PostMapping("/save")
    public ResponseEntity<Void> saverOrUpdateHirdetes(@RequestBody HirdetesekSaveMsg hirdetes) {
        hirdetesekService.saveOrUpdateHirdetes(hirdetes);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
	
	
	@PreAuthorize("hasRole('USER') || hasRole('ADMIN') || hasRole('SUPERUSER') || hasRole('SUPERADMIN')")
	@DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteHirdetes(@PathVariable Long id) {
        Hirdetesek hirdetes = hirdetesekRepository.findById(id).get();
        
        hirdetesekRepository.delete(hirdetes);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
	
	
}
