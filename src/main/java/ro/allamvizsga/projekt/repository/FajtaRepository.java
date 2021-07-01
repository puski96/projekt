package ro.allamvizsga.projekt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.minidev.json.JSONArray;
import ro.allamvizsga.projekt.message.FajtaSzamMsg;
import ro.allamvizsga.projekt.model.Fajta;


@Repository
public interface FajtaRepository extends JpaRepository<Fajta, Long>{
	
	public List<Fajta> findAll();
	List<Fajta> findByOrderByIdAsc();
	public Optional<Fajta> findById(Long id);
	public Optional<Fajta> findByAllattipus(String allattipus);
	public List<Fajta> findByAllattipusContainingIgnoreCase(String string);
	public Optional<Fajta> findByRovidites(String rovidites);
	public  Optional<Fajta> countKisallatokByFajta(String fajta);
	
	@Query("SELECT new ro.allamvizsga.projekt.message.FajtaSzamMsg(c.id, c.fajta, COUNT(b.id)) "
			  + "FROM Fajta AS c INNER JOIN Kisallat AS b ON c.id=b.fajta.id WHERE c.allattipus='iepure' GROUP BY c.id ORDER BY COUNT(b.id) DESC")
//	@Query("SELECT c.id, COUNT(c.kisallat) FROM Fajta AS c GROUP BY c.id ORDER BY c.id DESC")
	public List<Object> countTotalKisallatokByFajtaClassI();
	
	@Query("SELECT new ro.allamvizsga.projekt.message.FajtaSzamMsg(c.id, c.fajta, COUNT(b.id)) "
			  + "FROM Fajta AS c INNER JOIN Kisallat AS b ON c.id=b.fajta.id WHERE c.allattipus='gaina' GROUP BY c.id ORDER BY COUNT(b.id) DESC")
//	@Query("SELECT c.id, COUNT(c.kisallat) FROM Fajta AS c GROUP BY c.id ORDER BY c.id DESC")
	public List<Object> countTotalKisallatokByFajtaClassG();
	@Query("SELECT new ro.allamvizsga.projekt.message.FajtaSzamMsg(c.id, c.fajta, COUNT(b.id)) "
			  + "FROM Fajta AS c INNER JOIN Kisallat AS b ON c.id=b.fajta.id GROUP BY c.id ORDER BY COUNT(b.id) DESC ")
	public List<Object> countKisallatok();
	
}
