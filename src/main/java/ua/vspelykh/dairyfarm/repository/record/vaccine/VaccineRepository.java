package ua.vspelykh.dairyfarm.repository.record.vaccine;

import ua.vspelykh.dairyfarm.model.record.Calving;
import ua.vspelykh.dairyfarm.model.record.Vaccine;

import java.util.List;

public interface VaccineRepository {

    Vaccine getOne(int id);

    List<Vaccine> getAll();

    Vaccine save(Vaccine vaccine);

    boolean delete(int id);
}
