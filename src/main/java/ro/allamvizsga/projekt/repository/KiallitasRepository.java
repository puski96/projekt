package ro.allamvizsga.projekt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.allamvizsga.projekt.model.Kiallitas;

@Repository
public interface KiallitasRepository extends JpaRepository<Kiallitas, Long>{
	
	public List<Kiallitas> findAll();

	public Kiallitas getOne(Long id);


}
