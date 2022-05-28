package ua.vspelykh.dairyfarm.repository.farm;

import org.springframework.stereotype.Repository;
import ua.vspelykh.dairyfarm.model.entity.Farm;

import java.util.List;

@Repository
public class FarmRepositoryImpl implements FarmRepository {

    private final CrudFarmRepository farmRepository;

    public FarmRepositoryImpl(CrudFarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    @Override
    public Farm getOne(int id) {
        return farmRepository.getById(id);
    }

    @Override
    public List<Farm> getAll() {
        return farmRepository.findAll();
    }

    @Override
    public Farm save(Farm farm) {
        return farmRepository.save(farm);
    }

    @Override
    public boolean delete(int id) {
        return farmRepository.delete(id) != 0;
    }

    @Override
    public Farm getByEmail(String email) {
        return farmRepository.getByEmail(email);
    }

    @Override
    public Farm getByAddress(String address) {
        return farmRepository.getByAddressLike(address);
    }

    @Override
    public Farm getByOwner(String owner) {
        return farmRepository.getByOwnerLike(owner);
    }
}
