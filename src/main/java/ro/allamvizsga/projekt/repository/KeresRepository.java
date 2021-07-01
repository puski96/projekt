package ro.allamvizsga.projekt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.allamvizsga.projekt.model.Keres;


@Repository
public interface KeresRepository extends JpaRepository<Keres, Long>{
	
	public List<Keres> findAll();

	public Optional<Keres> findById(Long egyesuletId);

	public List<Keres> findAllByTulajdonosId(Long id);
}
