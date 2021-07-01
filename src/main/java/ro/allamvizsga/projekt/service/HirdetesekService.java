package ro.allamvizsga.projekt.service;

import java.util.List;

import ro.allamvizsga.projekt.message.HirdetesekMsg;
import ro.allamvizsga.projekt.message.HirdetesekSaveMsg;
import ro.allamvizsga.projekt.model.Hirdetesek;


public interface HirdetesekService {

	public void kiment(HirdetesekSaveMsg hirdetesek);
	        
	List<HirdetesekMsg> hirdetesek();
	Hirdetesek findById(Long id);

	void deleteHirdetes(Long id);


	void saveOrUpdateHirdetes(HirdetesekSaveMsg hirdetes);
}