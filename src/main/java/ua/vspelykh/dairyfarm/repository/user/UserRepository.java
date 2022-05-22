package ua.vspelykh.dairyfarm.repository.user;

import ua.vspelykh.dairyfarm.model.entity.User;

import java.util.List;

public interface UserRepository {

    User save(User user);

    boolean delete(int id);

    User get(int id);

    User getByEmail(String email);

    User getByName(String name);

    List<User> getAll();
}
