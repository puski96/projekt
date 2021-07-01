package ro.allamvizsga.projekt.service;

import java.util.List;
import java.util.Optional;

import ro.allamvizsga.projekt.message.EgyesuletMsg;
import ro.allamvizsga.projekt.model.Egyesulet;


public interface EgyesuletService {

	public void kiment(Egyesulet egyesulet);
	
	void updateEgyesulet(Egyesulet egyesulet);

	List<EgyesuletMsg> egyesuletek();

	public Optional<Egyesulet> findById(Long id);

}