package ro.allamvizsga.projekt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ro.allamvizsga.projekt.model.Kepfeltolt;

@Transactional
public interface KepRepository extends JpaRepository<Kepfeltolt, Long>{	
	public Optional<Kepfeltolt> findById(Long id);
	public List<Kepfeltolt> findAll();
	public void save(MultipartFile file);
	public List<Kepfeltolt> findAllByOrderByIdDesc();

}
