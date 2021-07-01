package ro.allamvizsga.projekt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.allamvizsga.projekt.model.Helyseg;

@Repository
public interface HelysegRepository extends JpaRepository<Helyseg, Long>{

	public List<Helyseg> findAll(); 
}
