package ua.vspelykh.dairyfarm.repository.cows;

import org.springframework.stereotype.Repository;
import ua.vspelykh.dairyfarm.model.entity.Cow;

import java.util.List;

@Repository
public class CowRepositoryImpl implements CowRepository{

    private final CrudCowRepository cowRepository;

    public CowRepositoryImpl(CrudCowRepository cowRepository) {
        this.cowRepository = cowRepository;
    }

    @Override
    public Cow getOne(int id) {
        return cowRepository.getReferenceById(id);
    }

    @Override
    public List<Cow> getAll() {
        return cowRepository.findAll();
    }

    @Override
    public Cow save(Cow cow) {
        return cowRepository.save(cow);
    }

    @Override
    public boolean delete(int id) {
        if (getOne(id) !=null) {
            cowRepository.delete(getOne(id));
            return true;
        }
        return false;
    }
}
