package ua.vspelykh.dairyfarm.service;

import org.springframework.stereotype.Service;
import ua.vspelykh.dairyfarm.model.entity.Farm;
import ua.vspelykh.dairyfarm.repository.farm.FarmRepository;

import java.util.List;

import static ua.vspelykh.dairyfarm.util.ValidationUtil.checkNotFound;
import static ua.vspelykh.dairyfarm.util.ValidationUtil.checkNotFoundWithId;

@Service
public class FarmService {

    private final FarmRepository repository;

    public FarmService(FarmRepository repository) {
        this.repository = repository;
    }

    public Farm create(Farm farm) {
        return repository.save(farm);
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public Farm get(int id) {
        return checkNotFoundWithId(repository.getOne(id), id);
    }

    public Farm getByEmail(String email) {
        return checkNotFound(repository.getByEmail(email), "email=" + email);
    }

    public List<Farm> getAll() {
        return repository.getAll();
    }

    public void update(Farm farm) {
        checkNotFoundWithId(repository.save(farm), farm.getId());
    }
}