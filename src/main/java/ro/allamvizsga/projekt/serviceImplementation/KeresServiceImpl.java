package ro.allamvizsga.projekt.serviceImplementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.allamvizsga.projekt.model.Egyesulet;
import ro.allamvizsga.projekt.model.Keres;
import ro.allamvizsga.projekt.repository.KeresRepository;
import ro.allamvizsga.projekt.service.KeresService;


@Service
public class KeresServiceImpl implements KeresService{

	@Autowired
	KeresRepository keresRepo;
	
	public void kiment(Keres keres) {
		keresRepo.save(keres);
	}
	@Override
	public Optional<Keres> findOneById(Long id) {
		return keresRepo.findById(id);
	}
}