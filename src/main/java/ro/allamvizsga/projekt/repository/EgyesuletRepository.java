package ro.allamvizsga.projekt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.allamvizsga.projekt.model.Egyesulet;

@Repository
public interface EgyesuletRepository extends JpaRepository<Egyesulet, Long> {

	public List<Egyesulet> findAll();
	
	public Optional<Egyesulet> findById(Optional<Egyesulet> long1);

	public Egyesulet findOneById(Long egyesuletId);

	public Optional<Egyesulet> findById(Long egyesuletId);

	
}
