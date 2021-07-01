package ro.allamvizsga.projekt.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.apache.logging.log4j.util.StringBuilderFormattable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.TrueCondition;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ro.allamvizsga.projekt.exception.UserExistsException;
import ro.allamvizsga.projekt.model.User;
import ro.allamvizsga.projekt.repository.UserRepository;
import ro.allamvizsga.projekt.repository.UserRoleRepository;
import ro.allamvizsga.projekt.service.UserService;


@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    UserRoleRepository userRoleRepo;
    
    @Autowired
    UserRepository userRepo;
    @PostMapping("/registration")
    public ResponseEntity<Object> registration(@Valid @RequestBody User user) {
        try {
            userService.registration(user);
        } catch (UserExistsException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
	@PreAuthorize("hasRole('SUPERADMIN')")
    @PutMapping("/upgrade/{id}")
    public void saveMember(@PathVariable Long id) {
		userService.update(id);
	}
	
	@PreAuthorize("hasRole('USER') || hasRole('ADMIN') || hasRole('SUPERUSER') || hasRole('SUPERADMIN')")
	@RequestMapping(method = RequestMethod.GET, path="/{userName}")
	public User geUser(@PathVariable String userName) {
		return userRepo.findOneByUserName(userName);
		
	}
}
