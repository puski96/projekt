package ro.allamvizsga.projekt.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.allamvizsga.projekt.model.Fajta;
import ro.allamvizsga.projekt.repository.FajtaRepository;
import ro.allamvizsga.projekt.service.FajtaService;


@Service
public class FajtaServiceImpl implements FajtaService{

	@Autowired
	FajtaRepository fajtaRepo;
	
	public void kiment(Fajta fajta) {
		//fajta=new Fajta();
		
		fajtaRepo.save(fajta);
	}

	@Override
	public void updateFajta(Fajta fajta) {
		Fajta regiFajta=fajtaRepo.getOne(fajta.getId());
		regiFajta.setFajta(fajta.getFajta());
		regiFajta.setFajtaleiras(fajta.getFajtaleiras());
		regiFajta.setKep(fajta.getKep());
		fajtaRepo.save(regiFajta);
		
	}
	
	
}
