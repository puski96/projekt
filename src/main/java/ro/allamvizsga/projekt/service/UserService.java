package ro.allamvizsga.projekt.service;

import ro.allamvizsga.projekt.exception.UserExistsException;
import ro.allamvizsga.projekt.model.User;

public interface UserService {
    public void registration(User user) throws UserExistsException;

	void update(Long id);

}
