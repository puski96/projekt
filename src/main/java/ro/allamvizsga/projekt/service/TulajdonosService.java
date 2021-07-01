package ro.allamvizsga.projekt.service;

import java.util.List;
import java.util.Optional;

import ro.allamvizsga.projekt.message.TulajdonosMsg;
import ro.allamvizsga.projekt.message.TulajdonosSaveMsg;
import ro.allamvizsga.projekt.model.Tulajdonos;


public interface TulajdonosService {
	
	public List<Tulajdonos> tulajok();


	void kiment(TulajdonosSaveMsg tulaj);


	public List<TulajdonosMsg> lista() ;

	void updateTulaj(TulajdonosSaveMsg tulajdonos);
	
}
