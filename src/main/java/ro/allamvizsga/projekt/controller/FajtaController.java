package ro.allamvizsga.projekt.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import liquibase.pro.packaged.iF;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import ro.allamvizsga.projekt.message.FajtaSzamMsg;
import ro.allamvizsga.projekt.model.Fajta;
import ro.allamvizsga.projekt.model.Kisallat;
import ro.allamvizsga.projekt.repository.FajtaRepository;
import ro.allamvizsga.projekt.repository.KisallatRepository;
import ro.allamvizsga.projekt.service.FajtaService;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/api/fajta")
public class FajtaController {

	@Autowired
	FajtaService fajtaService;
	
	@Autowired
	FajtaRepository fajtaRepo;
	
	@RequestMapping(method = RequestMethod.POST, path = "/test", consumes = "application/json", produces = "application/json")
	public String test(@RequestBody Fajta fajta) {
		fajtaService.kiment(fajta);
		return "sikeres";
	}
	@GetMapping()
	public List<Fajta> hello() {
		System.out.println();
		return fajtaRepo.findByOrderByIdAsc();
	}
	
	@Autowired
	KisallatRepository kisallatRepo;
	
	@RequestMapping(method = RequestMethod.GET, path = "/counterI")
	public List<Object> count(){
		System.out.println(fajtaRepo.countTotalKisallatokByFajtaClassI());
		return fajtaRepo.countTotalKisallatokByFajtaClassI();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/counterG")
	public List<Object> countG(){
		System.out.println(fajtaRepo.countTotalKisallatokByFajtaClassG());
		return fajtaRepo.countTotalKisallatokByFajtaClassG();
	}
	@RequestMapping(method = RequestMethod.GET, path = "/counterT")
	public List<Object> countT(){
		System.out.println(fajtaRepo.countKisallatok());
		return fajtaRepo.countKisallatok();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/{string}")
	public Optional<Fajta> getOne(@PathVariable String string){
		return fajtaRepo.findByRovidites(string);
	}
	@RequestMapping(method = RequestMethod.GET, path = "/filtered/{string}")
	public List<Fajta> nyulak(@PathVariable String string){
		return fajtaRepo.findByAllattipusContainingIgnoreCase(string);
		
	}
//	@RequestMapping(method = RequestMethod.GET, path = "/nyulak")
//	public List<Fajta> findByAllattipus(){
//		List<Fajta> osszes= fajtaRepo.findAll();
//		List<Fajta> nyulak = null;
//		for (int i = 0; i < osszes.size(); i++) {
//			if(osszes.get(i).getAllattipus().equals("iepure")) {
//				nyulak.add(osszes.get(i));
//			}
//		}
//		return nyulak;
//		
//	}
	
		
	
}
