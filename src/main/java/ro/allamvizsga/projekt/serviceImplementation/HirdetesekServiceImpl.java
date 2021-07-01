package ro.allamvizsga.projekt.serviceImplementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.allamvizsga.projekt.message.HirdetesekMsg;
import ro.allamvizsga.projekt.message.HirdetesekSaveMsg;
import ro.allamvizsga.projekt.model.Hirdetesek;
import ro.allamvizsga.projekt.model.Kepfeltolt;
import ro.allamvizsga.projekt.model.Tulajdonos;
import ro.allamvizsga.projekt.repository.HirdetesekRepository;
import ro.allamvizsga.projekt.repository.KepRepository;
import ro.allamvizsga.projekt.repository.TulajdonosRepository;
import ro.allamvizsga.projekt.service.HirdetesekService;

@Service
public class HirdetesekServiceImpl implements HirdetesekService{

	@Autowired
	HirdetesekRepository hirdetesekRepository;
	
	@Autowired
	KepRepository kepRepository;
	
	@Autowired
	TulajdonosRepository tulajRepo;
	
	
	public void kiment(HirdetesekSaveMsg hirdetes) {
        hirdetesekRepository.save(hirdetes);
	}

	@Override
	public List<HirdetesekMsg> hirdetesek() {
		return hirdetesekRepository.findAll().stream().map(HirdetesekMsg::new).collect(Collectors.toList());
	}
	
	@Override
    public void deleteHirdetes(Long id) {
        hirdetesekRepository.deleteById(id);
    }

	@Override
    public void saveOrUpdateHirdetes(HirdetesekSaveMsg hirdetes) {
		Hirdetesek ujhirdetes=new Hirdetesek();
		ujhirdetes.setId(hirdetes.getId());
		ujhirdetes.setAr(hirdetes.getAr());
		ujhirdetes.setNev(hirdetes.getNev());
		ujhirdetes.setDb(hirdetes.getDb());
		ujhirdetes.setLeiras(hirdetes.getLeiras());
		Long tulajId=hirdetes.getTulajId();
		Optional<Tulajdonos> tulaj=tulajRepo.findById(tulajId);
		tulaj.ifPresent(keresettTulaj->{
			ujhirdetes.setHelyseg(keresettTulaj.getHelyseg());
			ujhirdetes.setTulajdonos(keresettTulaj);
		});
		
        hirdetesekRepository.save(ujhirdetes);
    }

		public Hirdetesek findById(Long id) {
			return hirdetesekRepository.findById(id).get();
		}

			
}
