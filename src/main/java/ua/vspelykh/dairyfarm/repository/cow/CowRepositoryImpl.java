package ua.vspelykh.dairyfarm.repository.cow;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.vspelykh.dairyfarm.model.entity.Cow;
import ua.vspelykh.dairyfarm.repository.farm.CrudFarmRepository;

import java.util.List;

@Repository
public class CowRepositoryImpl implements CowRepository {

    private final CrudCowRepository cowRepository;
    private final CrudFarmRepository farmRepository;

    public CowRepositoryImpl(CrudCowRepository crudCowRepository, CrudFarmRepository farmRepository) {
        this.cowRepository = crudCowRepository;
        this.farmRepository = farmRepository;
    }

    public Cow getOne(int id, int farmId){
        return cowRepository.findById(id)
                .filter(cow -> cow.getFarm().getId() == farmId)
                .orElse(null);
    }

    public List<Cow> getAll(Integer farmId){
        return cowRepository.getAllByFarmId(farmId);
    }

    @Transactional
    public Cow save(Cow cow, int farmId){
        if (!cow.isNew() && getOne(cow.getId(), farmId) == null){
            return null;
        }
        cow.setFarm(farmRepository.getReferenceById(farmId));
        return cowRepository.save(cow);
    }

    public boolean delete(int id, int farmId){
        return cowRepository.delete(id, farmId) != 0;
    }

    @Override
    public Cow getWithFullInfo(int id, int farmId){
        return cowRepository.getWithFullInfo(id, farmId);
    }
}
