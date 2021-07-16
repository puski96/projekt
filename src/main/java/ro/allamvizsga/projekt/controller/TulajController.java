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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ro.allamvizsga.projekt.exception.ResourceNotFoundException;
import ro.allamvizsga.projekt.message.TulajdonosMsg;
import ro.allamvizsga.projekt.message.TulajdonosSaveMsg;
import ro.allamvizsga.projekt.model.Hirdetesek;
import ro.allamvizsga.projekt.model.Tulajdonos;
import ro.allamvizsga.projekt.repository.TulajdonosRepository;
import ro.allamvizsga.projekt.service.TulajdonosService;


@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("/api/tulaj")
public class TulajController {

	@Autowired
	TulajdonosRepository tulajRepo;
	
	@Autowired
	TulajdonosService tulajService;
	
	
	@RequestMapping(method = RequestMethod.POST, path = "/save", consumes = "application/json", produces = "application/json")
	public String test3(@RequestBody TulajdonosSaveMsg tulaj) {
		tulajService.kiment(tulaj);
		return "sikeres";
	}
	
	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERADMIN')")
	@GetMapping()
	public List<Tulajdonos> hello() {
		return tulajRepo.findAll();
	}
	
	@PreAuthorize("hasRole('USER') || hasRole('ADMIN') || hasRole('SUPERUSER') || hasRole('SUPERADMIN')")
	@RequestMapping(method = RequestMethod.GET, path = "/get")
	public List<TulajdonosMsg> test() {
 		return tulajRepo.findAll().stream().map(TulajdonosMsg::new).collect(Collectors.toList());

	}
	
	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERADMIN')")
	@RequestMapping(method = RequestMethod.POST, path = "/update", consumes = "application/json", produces = "application/json")
	public String update(@RequestBody TulajdonosSaveMsg tulajdonos) {
		tulajService.updateTulaj(tulajdonos);
		return "sikeres";
	}
	
//	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERADMIN')")
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public Optional<Tulajdonos> getOne(@PathVariable Long id){
		return tulajRepo.findById(id);
	}
	
	@PreAuthorize("hasRole('USER') || hasRole('ADMIN') || hasRole('SUPERUSER') || hasRole('SUPERADMIN')")
	@RequestMapping(method = RequestMethod.GET, path="/email/{email}")
	public Tulajdonos getByEmail(@PathVariable Long email) {
		return tulajRepo.getOneByUserId(email);
		
	}
	
	@PreAuthorize("hasRole('ADMIN') || hasRole('SUPERADMIN')")
	@DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteTulajdonos(@PathVariable Long id) {
        Tulajdonos tulaj = tulajRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tulajdonos not exist with id :" + id));;
        
        tulajRepo.delete(tulaj);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
