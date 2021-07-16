package ro.allamvizsga.projekt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import ro.allamvizsga.projekt.message.KisallatSaveMsg;
import ro.allamvizsga.projekt.model.Kiallitas;
import ro.allamvizsga.projekt.model.Kisallat;
import ro.allamvizsga.projekt.repository.KiallitasRepository;
import ro.allamvizsga.projekt.service.KiallitasService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/kiallitas")
public class KiallitasController {

	@Autowired
	KiallitasService kiallitasService;
	
	@Autowired
	KiallitasRepository kiallitasRepo;
	
	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERADMIN')")
	@RequestMapping(method = RequestMethod.POST, path = "/save", consumes = "application/json", produces = "application/json")
	public String mentes(@RequestBody Kiallitas kiallitas) {
		kiallitasService.kiment(kiallitas);
		return "sikeres";
	}
	@GetMapping()
	public List<Kiallitas> hello() {
		return kiallitasRepo.findAll();
	}
	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERADMIN')")
	@RequestMapping(method = RequestMethod.POST, path = "/update", consumes = "application/json", produces = "application/json")
	public String update(@RequestBody Kiallitas kiallitas) {
		kiallitasService.updateKiallitas(kiallitas);
		return "sikeres";
	}
	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERADMIN')")
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public Optional<Kiallitas> getOne(@PathVariable Long id){
		return kiallitasRepo.findById(id);
	}
	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERADMIN')")
	@DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteKiallitas(@PathVariable Long id) {
        Kiallitas kiallitas= kiallitasRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tulajdonos not exist with id :" + id));;
        
        kiallitasRepo.delete(kiallitas);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
