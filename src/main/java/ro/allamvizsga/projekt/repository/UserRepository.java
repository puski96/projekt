package ro.allamvizsga.projekt.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ro.allamvizsga.projekt.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUserNameAndIsConfirmedTrue(String userName);

    public User findOneByUserName(String userName);

}