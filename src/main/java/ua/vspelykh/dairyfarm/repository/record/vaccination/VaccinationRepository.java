package ua.vspelykh.dairyfarm.repository.record.vaccination;

import ua.vspelykh.dairyfarm.model.record.Vaccination;

import java.util.List;

public interface VaccinationRepository {

    Vaccination getOne(int id, int cowId);

    List<Vaccination> getAll(int cowId);

    Vaccination save(Vaccination vaccination, int cowId);

    boolean delete(int id, int cowId);
}
