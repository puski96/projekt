package ro.allamvizsga.projekt.serviceImplementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonBackReference;

import ro.allamvizsga.projekt.message.KiallresztveszSaveMsg;
import ro.allamvizsga.projekt.model.Fajta;
import ro.allamvizsga.projekt.model.Kiallitas;
import ro.allamvizsga.projekt.model.Kiallresztvesz;
import ro.allamvizsga.projekt.model.Kisallat;
import ro.allamvizsga.projekt.model.Tulajdonos;
import ro.allamvizsga.projekt.repository.KiallResztVeszRepository;
import ro.allamvizsga.projekt.repository.KiallitasRepository;
import ro.allamvizsga.projekt.repository.KisallatRepository;
import ro.allamvizsga.projekt.service.KiallresztveszService;


@Service
public class KiallResztveszServiceImpl implements KiallresztveszService{

	@Autowired
	KiallResztVeszRepository kiallresztveszRepo;
	
	@Autowired
	KiallitasRepository kiallitasRepo;
	
	@Autowired
	KisallatRepository kisallatRepo;
	
	@Override
	@JsonBackReference
	public void kiment(KiallresztveszSaveMsg kiallResztvesz) {
		Kiallresztvesz resztvesz=new Kiallresztvesz();
		resztvesz.setPontszam(kiallResztvesz.getPontszam());
		Long kiallitasId=kiallResztvesz.getKiallitasId();
		Optional<Kiallitas> resztvetel=kiallitasRepo.findById(kiallitasId);
		resztvetel.ifPresent(keresett->{
			resztvesz.setKiallitas(keresett);
		});
		Long kisallatId=kiallResztvesz.getKisallatId();
		Optional<Kisallat> kisallat= kisallatRepo.findById(kisallatId);
		kisallat.ifPresent(keresettaallat->{
			resztvesz.setKisallat(keresettaallat);
		});
		kiallresztveszRepo.save(resztvesz);
	}

//	@Override
//	public void updateKiallresztvesz(Kiallresztvesz kiallresztvesz) {
//		Kiallresztvesz regiReKiallresztvesz=kiallresztveszRepo.getOne(kiallresztvesz.getId());
//		regiReKiallresztvesz.setKiallitas(kiallresztvesz.getKiallitas());
//		regiReKiallresztvesz.setPontszam(kiallresztvesz.getPontszam());
//		kiallresztveszRepo.save(regiReKiallresztvesz);
//	}

	@Override
	public void updateKiallresztvesz(KiallresztveszSaveMsg kiallresztveszSaveMsg) {
		Kiallresztvesz kiallresztvesz=kiallresztveszRepo.getOne(kiallresztveszSaveMsg.getId());
		kiallresztvesz.setId(kiallresztveszSaveMsg.getId());
		kiallresztvesz.setPontszam(kiallresztveszSaveMsg.getPontszam());
		Long kisallatId=kiallresztveszSaveMsg.getKisallatId();
		Optional<Kisallat> kisallat=kisallatRepo.findById(kisallatId);
		kisallat.ifPresent(keresettKisallat->{
			kiallresztvesz.setKisallat(keresettKisallat);
		});
		Long kiallitasId=kiallresztveszSaveMsg.getKiallitasId();
		Optional<Kiallitas> kiallitas=kiallitasRepo.findById(kiallitasId);
		kiallitas.ifPresent(keresettKiallitas->{
			kiallresztvesz.setKiallitas(keresettKiallitas);
			});
		kiallresztveszRepo.save(kiallresztvesz);
		
	}


}
