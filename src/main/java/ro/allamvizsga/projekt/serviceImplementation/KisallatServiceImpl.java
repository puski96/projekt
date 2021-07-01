package ro.allamvizsga.projekt.serviceImplementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.allamvizsga.projekt.message.KisallatSaveMsg;
import ro.allamvizsga.projekt.message.KisallatSelectMsg;
import ro.allamvizsga.projekt.model.Fajta;
import ro.allamvizsga.projekt.model.Kisallat;
import ro.allamvizsga.projekt.model.Tulajdonos;
import ro.allamvizsga.projekt.repository.FajtaRepository;
import ro.allamvizsga.projekt.repository.KisallatRepository;
import ro.allamvizsga.projekt.repository.TulajdonosRepository;
import ro.allamvizsga.projekt.service.KisallatService;


@Service
public class KisallatServiceImpl implements KisallatService{

	@Autowired
	KisallatRepository kisallatRepo;
	@Autowired
	TulajdonosRepository tulajRepo;
	@Autowired
	FajtaRepository fajtaRepo;
	
	
	@Override
	public void kiment(KisallatSaveMsg kisallat) {
		Kisallat allat=new Kisallat();
		allat.setJobbful(kisallat.getJobbful());
		allat.setBalful(kisallat.getBalful());
		allat.setNem(kisallat.getNem());
		Long fajtaId=kisallat.getFajtaId();
		Optional<Fajta> fajta=fajtaRepo.findById(fajtaId);
		fajta.ifPresent(keresettFajta->{
			allat.setFajta(keresettFajta);
		});
		Long tulajId=kisallat.getTulajId();
		Optional<Tulajdonos> tulaj=tulajRepo.findById(tulajId);
		tulaj.ifPresent(keresettTulaj->{
			allat.setTulaj(keresettTulaj);
		});
		kisallatRepo.save(allat);
	}

	
	@Override
	public void updateKisallat(KisallatSaveMsg kisallat) {
			Kisallat regiKiallat=kisallatRepo.getOne(kisallat.getId());
			regiKiallat.setId(kisallat.getId());
			regiKiallat.setJobbful(kisallat.getJobbful());
			regiKiallat.setBalful(kisallat.getBalful());
			regiKiallat.setNem(kisallat.getNem());
//			regiKiallat.setReszvetel(kisallat.getReszvetel());
			Long fajtaId=kisallat.getFajtaId();
			Optional<Fajta> fajta=fajtaRepo.findById(fajtaId);
			fajta.ifPresent(keresettFajta->{
				regiKiallat.setFajta(keresettFajta);
			});
			Long tulajId=kisallat.getTulajId();
			Optional<Tulajdonos> tulaj=tulajRepo.findById(tulajId);
			tulaj.ifPresent(keresettTulaj->{
				regiKiallat.setTulaj(keresettTulaj);
			});
			kisallatRepo.save(regiKiallat);
		
	}


	@Override
	public List<KisallatSelectMsg> lista() {
		return kisallatRepo.findAll().stream().map(KisallatSelectMsg::new).collect(Collectors.toList());
	}
	
}
