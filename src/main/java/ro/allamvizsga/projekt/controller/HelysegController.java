package ro.allamvizsga.projekt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.allamvizsga.projekt.model.Helyseg;
import ro.allamvizsga.projekt.repository.HelysegRepository;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/api/helysegek")
public class HelysegController {
	@Autowired
	HelysegRepository helysegRepo;
	
	@GetMapping()
	public List<Helyseg> hello() {
		System.out.println();
		return helysegRepo.findAll();
	}
}
