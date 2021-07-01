package ro.allamvizsga.projekt.service;

import java.util.List;

import ro.allamvizsga.projekt.message.KisallatSaveMsg;
import ro.allamvizsga.projekt.message.KisallatSelectMsg;
import ro.allamvizsga.projekt.model.Kisallat;


public interface KisallatService {

	

	void kiment(KisallatSaveMsg kisallat);
	
	public List<KisallatSelectMsg> lista() ;

	void updateKisallat(KisallatSaveMsg kisallat);

}
