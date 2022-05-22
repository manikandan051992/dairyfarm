package ua.vspelykh.dairyfarm.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ua.vspelykh.dairyfarm.model.entity.Cow;
import ua.vspelykh.dairyfarm.repository.cows.CowRepository;

import java.util.List;

import static ua.vspelykh.dairyfarm.util.ValidationUtil.checkNotFoundWithId;

@Service
public class CowService {
    private final CowRepository repository;

    public CowService(CowRepository cowRepository) {
        this.repository = cowRepository;
    }


    public Cow get(int id, int farmId) {
        return checkNotFoundWithId(repository.getOne(id, farmId), id);
    }

//    public Cow getWithFullInfo(int id, int farmId){
//        checkNotFoundWithId(repository.getOne(id, farmId), id);
//        return repository.getWithFullInfo(id, farmId);
//    }

    public void delete(int id, int farmId) {
        checkNotFoundWithId(repository.delete(id, farmId), id);
    }

    public List<Cow> getAll(int farmId) {
        return repository.getAll(farmId);
    }

    public void update(Cow cow, int farmId) {
        Assert.notNull(cow, "cow must not be null");
        checkNotFoundWithId(repository.save(cow, farmId), cow.getId());
    }

    public Cow create(Cow cow, int farmId) {
        Assert.notNull(cow, "cow must not be null");
        return repository.save(cow, farmId);
    }

}