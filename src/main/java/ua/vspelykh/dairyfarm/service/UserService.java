package ua.vspelykh.dairyfarm.service;
import ua.vspelykh.dairyfarm.model.entity.User;
import ua.vspelykh.dairyfarm.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static ua.vspelykh.dairyfarm.util.ValidationUtil.checkNotFound;
import static ua.vspelykh.dairyfarm.util.ValidationUtil.checkNotFoundWithId;


@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(User user) {
        return repository.save(user);
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public User get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public User getByEmail(String email) {
        return checkNotFound(repository.getByEmail(email), "email=" + email);
    }

    public List<User> getAll() {
        return repository.getAll();
    }

    public void update(User user) {
        checkNotFoundWithId(repository.save(user), user.getId());
    }
}