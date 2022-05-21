package ua.vspelykh.dairyfarm.repository.farm;

import ua.vspelykh.dairyfarm.model.entity.Farm;

import java.util.List;

public interface FarmRepository {

        Farm getOne(int id);

        List<Farm> getAll();

        Farm save(Farm farm);

        boolean delete(int id);

        Farm getByEmail(String email);
}
