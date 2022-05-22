package ua.vspelykh.dairyfarm.repository.user;

import org.springframework.stereotype.Repository;
import ua.vspelykh.dairyfarm.model.entity.Farm;
import ua.vspelykh.dairyfarm.model.entity.User;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {


    private final CrudUserRepository userRepository;

    public UserRepositoryImpl(CrudUserRepository userRepository) {
        this.userRepository = userRepository;
    }


        public Farm getFarm(int userId){
        return userRepository.getFarmById(userId);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean delete(int id) {
        return userRepository.delete(id) != 0;
    }

    @Override
    public User get(int id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    @Override
    public User getByName(String name) {
        return userRepository.getByNameContaining(name);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}