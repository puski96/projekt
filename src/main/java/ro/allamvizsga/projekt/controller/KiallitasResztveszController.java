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
import ro.allamvizsga.projekt.message.KiallresztveszSaveMsg;
import ro.allamvizsga.projekt.message.TulajdonosSaveMsg;
import ro.allamvizsga.projekt.model.Kiallresztvesz;
import ro.allamvizsga.projekt.model.Kisallat;
import ro.allamvizsga.projekt.model.Tulajdonos;
import ro.allamvizsga.projekt.repository.KiallResztVeszRepository;
import ro.allamvizsga.projekt.service.KiallresztveszService;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/api/kresztvesz")
public class KiallitasResztveszController {

	@Autowired
	KiallresztveszService kresztveszService;
	
	@Autowired
	KiallResztVeszRepository kiallresztveszRepo;
	
	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERADMIN')")
	@RequestMapping(method = RequestMethod.POST, path = "/save", consumes = "application/json", produces = "application/json")
	public String mentes(@RequestBody KiallresztveszSaveMsg kresztvesz) {
		kresztveszService.kiment(kresztvesz);
		return "sikeres";
	}
	
	@GetMapping()
	public List<Kiallresztvesz> lista() {
		return kiallresztveszRepo.findAll();
	}
	
	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERADMIN')")
	@RequestMapping(method = RequestMethod.POST, path = "/update", consumes = "application/json", produces = "application/json")
	public String update(@RequestBody KiallresztveszSaveMsg kiallresztveszSaveMsg) {
		kresztveszService.updateKiallresztvesz(kiallresztveszSaveMsg);
		return "sikeres";
	}
	
	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERADMIN')")
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public Optional<Kiallresztvesz> getOne(@PathVariable Long id){
		return kiallresztveszRepo.findById(id);
	}
	@RequestMapping(method = RequestMethod.GET, path = "/kiallitasok/{id}")
	public List<Kiallresztvesz> findByKiallitas(@PathVariable Long id){
		return kiallresztveszRepo.findAllByKiallitasId(id);
	}
	
	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERADMIN')")
	@RequestMapping(method = RequestMethod.GET, path = "/get/{id}")
	public Optional<Kiallresztvesz> findOne(@PathVariable Long id){
		return kiallresztveszRepo.findByKisallatId(id);
	}
	
	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERADMIN')")
	@DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteReszvetel(@PathVariable Long id) {
        Kiallresztvesz kiallresztvesz = kiallresztveszRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tulajdonos not exist with id :" + id));;
        
        kiallresztveszRepo.delete(kiallresztvesz);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
