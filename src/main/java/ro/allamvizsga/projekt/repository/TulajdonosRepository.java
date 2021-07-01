package ro.allamvizsga.projekt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ro.allamvizsga.projekt.message.TulajdonosMsg;
import ro.allamvizsga.projekt.model.Egyesulet;
import ro.allamvizsga.projekt.model.Tulajdonos;
import ro.allamvizsga.projekt.model.User;


@Repository
public interface TulajdonosRepository extends JpaRepository<Tulajdonos, Long> {


	public List<Tulajdonos> findAll();
	
	public List<Tulajdonos> findByEgyesulet(Egyesulet egyesulet);
	
	public Tulajdonos getOneByUserId(Long email);
	public Tulajdonos getOne(Long id);

}
