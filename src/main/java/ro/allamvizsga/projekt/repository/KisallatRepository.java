package ro.allamvizsga.projekt.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ro.allamvizsga.projekt.message.FajtaSzamMsg;
import ro.allamvizsga.projekt.message.KisallatSelectMsg;
import ro.allamvizsga.projekt.model.Fajta;
import ro.allamvizsga.projekt.model.Kisallat;


@Repository
public interface KisallatRepository extends JpaRepository<Kisallat, Long>{
	
	public List<Kisallat> findAll();

	public Kisallat getOne(Long id);

	public Optional<Kisallat> findByTulajId(Long id);

//	@Query("SELECT new ro.allamvizsga.projekt.message.FajtaSzamMsg(c.jobbful, COUNT(c.fajta.id))"
//			+"FROM Kisallat AS c GROUP BY c.fajta.id ORDER BY c.fajta DESC")
//	public List<Object[]> countTotalKisallatokByFajtaClass();
	
}
