package ro.allamvizsga.projekt.service;

import java.util.Optional;

import ro.allamvizsga.projekt.model.Egyesulet;
import ro.allamvizsga.projekt.model.Keres;

public interface KeresService {

	public void kiment(Keres keres);

	public Optional<Keres> findOneById(Long egyesuletId);

}
