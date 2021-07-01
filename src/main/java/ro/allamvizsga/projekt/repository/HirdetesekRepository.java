package ro.allamvizsga.projekt.repository;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ro.allamvizsga.projekt.message.HirdetesekSaveMsg;
import ro.allamvizsga.projekt.model.Hirdetesek;

@Repository
@Transactional
public interface HirdetesekRepository extends JpaRepository<Hirdetesek, Long>{
	
	public List<Hirdetesek> findAll();

	public Hirdetesek save(HirdetesekSaveMsg hirdetesek);

	public Collection<Hirdetesek> findAllByOrderById();
	
//	@Query("SELECT new ro.allamvizsga.projekt.message.HirdMsg(c.id, c.eladva, COUNT(c.eladva)) "
//			  + "FROM Hirdetes AS c GROUP BY c.id ORDER BY COUNT(c.eladva) DESC")
	@Query("SELECT c.eladva,  COUNT(c.eladva) FROM Hirdetesek AS c GROUP BY c.eladva ORDER BY COUNT(c.eladva) DESC")
	public List<Object> countTotalHirdetesekByEladva();

	public List<Hirdetesek> findAllByTulajdonosId(Long id);
}