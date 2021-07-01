package ro.allamvizsga.projekt.serviceImplementation;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ro.allamvizsga.projekt.exception.UserExistsException;
import ro.allamvizsga.projekt.model.User;
import ro.allamvizsga.projekt.model.UserRole;
import ro.allamvizsga.projekt.repository.UserRepository;
import ro.allamvizsga.projekt.repository.UserRoleRepository;
import ro.allamvizsga.projekt.service.UserService;


@Service(value = "userService")
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRoleRepository userRoleRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepo.findByUserNameAndIsConfirmedTrue(s);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                user.getUserRoles());
    }

    @Override
    public void registration(User user) throws UserExistsException {
        User oldUser = userRepo.findOneByUserName(user.getUserName());
        if(oldUser != null) {
            throw new UserExistsException();
        }

        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(userRoleRepo.findById(1L).get());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setConfirmed(true);
        user.setUserRoles(userRoles);
        userRepo.save(user);
    }
    
    @Override
    public void update(Long id) {
        User user = userRepo.getOne(id);
                Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(userRoleRepo.findById(2L).get());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setConfirmed(true);
        user.setUserRoles(userRoles);
        userRepo.save(user);
    }

}
