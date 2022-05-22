package ua.vspelykh.dairyfarm.repository.cows;

import ua.vspelykh.dairyfarm.model.entity.Cow;

import java.util.List;

public interface CowRepository {

    Cow getOne(int id, int farmId);

    List<Cow> getAll(Integer farmId);

    Cow save(Cow cow, int farmId);

    boolean delete(int id, int farmId);

    default Cow getWithFullInfo(int id, int farmId){
        throw new UnsupportedOperationException();
    }
}
