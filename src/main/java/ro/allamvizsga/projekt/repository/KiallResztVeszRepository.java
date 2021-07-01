package ro.allamvizsga.projekt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.allamvizsga.projekt.model.Kiallresztvesz;

@Repository
public interface KiallResztVeszRepository extends JpaRepository<Kiallresztvesz, Long>{
	
	public List<Kiallresztvesz> findAll();

	public Kiallresztvesz getOne(Long id);

	public Optional<Kiallresztvesz> findByKisallatId(Long id);
	
	public List<Kiallresztvesz> findAllByKiallitasId(Long id);


}

