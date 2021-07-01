package ro.allamvizsga.projekt.serviceImplementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonBackReference;

import ro.allamvizsga.projekt.message.TulajdonosMsg;
import ro.allamvizsga.projekt.message.TulajdonosSaveMsg;
import ro.allamvizsga.projekt.model.Egyesulet;
import ro.allamvizsga.projekt.model.Tulajdonos;
import ro.allamvizsga.projekt.repository.EgyesuletRepository;
import ro.allamvizsga.projekt.repository.FajtaRepository;
import ro.allamvizsga.projekt.repository.TulajdonosRepository;
import ro.allamvizsga.projekt.service.EgyesuletService;
import ro.allamvizsga.projekt.service.TulajdonosService;


@Service
public class TulajdonosServiceImpl implements TulajdonosService {

	@Autowired
	TulajdonosRepository tulajRepo;

	@Autowired
	EgyesuletRepository egyesuletRepo;
	
	@Autowired
	FajtaRepository fajtaRepo;
	
	@Autowired
	EgyesuletService egyservice;
	
	@Override
	@JsonBackReference
	public void kiment(TulajdonosSaveMsg tulajdonos) {
		Tulajdonos tulaj=new Tulajdonos();
		tulaj.setId(tulaj.getId());
		tulaj.setNev(tulajdonos.getNev());
		tulaj.setCim(tulajdonos.getCim());
		tulaj.setBiro(tulajdonos.isBiro());
		tulaj.setTelszam(tulajdonos.getTelszam());
		Long egyesuletId=tulajdonos.getEgyesuletId();
		Optional<Egyesulet> egyesulet=egyesuletRepo.findById(egyesuletId);
		egyesulet.ifPresent(keresett->{
			tulaj.setEgyesulet(keresett);
		});		
		tulajRepo.save(tulaj);
	}	
	
	@Override
	@PostConstruct
	@JsonBackReference
	public List<Tulajdonos> tulajok() {
		return tulajRepo.findAll();

		
	}
	TulajdonosMsg tulajdonosMsg;
	
	public List<TulajdonosMsg> lista() {
		System.out.println("tulaj service metodus");
		return tulajRepo.findAll().stream().map(TulajdonosMsg::new).collect(Collectors.toList());
	}

	@Override
	public void updateTulaj(TulajdonosSaveMsg tulajdonos) {
		Tulajdonos regiTulajdonos=tulajRepo.getOne(tulajdonos.getId());
		regiTulajdonos.setId(tulajdonos.getId());
		regiTulajdonos.setNev(tulajdonos.getNev());
		regiTulajdonos.setCim(tulajdonos.getCim());
		regiTulajdonos.setBiro(tulajdonos.isBiro());
		Long egyesuletId=tulajdonos.getEgyesuletId();
		Optional<Egyesulet> egyesulet=egyesuletRepo.findById(egyesuletId);
		egyesulet.ifPresent(keresett->{
			regiTulajdonos.setEgyesulet(keresett);
		});				
		regiTulajdonos.setTelszam(tulajdonos.getTelszam());
		tulajRepo.save(regiTulajdonos);
	}

	


}
