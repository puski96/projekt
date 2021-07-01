package ro.allamvizsga.projekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.allamvizsga.projekt.model.UserRole;


@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

}
