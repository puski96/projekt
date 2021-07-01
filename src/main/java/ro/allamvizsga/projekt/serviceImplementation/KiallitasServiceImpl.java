package ro.allamvizsga.projekt.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.allamvizsga.projekt.model.Kiallitas;
import ro.allamvizsga.projekt.repository.KiallitasRepository;
import ro.allamvizsga.projekt.service.KiallitasService;


@Service
public class KiallitasServiceImpl implements KiallitasService{

	@Autowired
	KiallitasRepository kiallitasRepo;
	
	public void kiment(Kiallitas kiallitas) {
		Kiallitas kiallitas2=new Kiallitas();
		kiallitas2.setHelyseg(kiallitas.getHelyseg());
		kiallitas2.setKezdodatum(kiallitas.getKezdodatum());
		kiallitas2.setVegdatum(kiallitas.getVegdatum());
		kiallitasRepo.save(kiallitas2);
	}

	@Override
	public void updateKiallitas(Kiallitas kiallitas) {
		Kiallitas regiKiallitas=kiallitasRepo.getOne(kiallitas.getId());
		regiKiallitas.setHelyseg(kiallitas.getHelyseg());
		regiKiallitas.setKezdodatum(kiallitas.getKezdodatum());
		regiKiallitas.setResztvetelek(kiallitas.getResztvetelek());
		regiKiallitas.setVegdatum(kiallitas.getVegdatum());
		kiallitasRepo.save(regiKiallitas);
	}

}
