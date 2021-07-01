package ro.allamvizsga.projekt.serviceImplementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.allamvizsga.projekt.message.EgyesuletMsg;
import ro.allamvizsga.projekt.model.Egyesulet;
import ro.allamvizsga.projekt.repository.EgyesuletRepository;
import ro.allamvizsga.projekt.service.EgyesuletService;

@Service
public class EgyesuletServiceImpl implements EgyesuletService{

	@Autowired
	EgyesuletRepository egyesuletRepo;
	
	public void kiment(Egyesulet egyesulet) {
		egyesuletRepo.save(egyesulet);
	}

	@Override
	public void updateEgyesulet(Egyesulet egyesulet) {
		Egyesulet regiEgyesulet=egyesuletRepo.getOne(egyesulet.getId());
		regiEgyesulet.setElnok(egyesulet.getElnok());
		regiEgyesulet.setNev(egyesulet.getNev());
		regiEgyesulet.setTulajok(egyesulet.getTulajok());
		regiEgyesulet.setAzonosito(egyesulet.getAzonosito());
		egyesuletRepo.save(regiEgyesulet);
		
	}
	

	EgyesuletMsg egyesuletmsg;
	
	@Override
	public List<EgyesuletMsg> egyesuletek() {
		return egyesuletRepo.findAll().stream().map(EgyesuletMsg::new).collect(Collectors.toList());
	}


	@Override
	public Optional<Egyesulet> findById(Long id) {
		return egyesuletRepo.findById(id);
	}

	}
