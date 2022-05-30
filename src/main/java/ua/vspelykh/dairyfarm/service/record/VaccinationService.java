package ua.vspelykh.dairyfarm.service.record;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ua.vspelykh.dairyfarm.model.record.Calving;
import ua.vspelykh.dairyfarm.model.record.Vaccination;
import ua.vspelykh.dairyfarm.repository.record.vaccination.VaccinationRepository;

import java.util.List;

import static ua.vspelykh.dairyfarm.util.ValidationUtil.checkNotFoundWithId;

@Service
public class VaccinationService {

    private final VaccinationRepository repository;

    public VaccinationService(VaccinationRepository repository) {
        this.repository = repository;
    }

    public Vaccination get(int id, int cowId) {
        return checkNotFoundWithId(repository.getOne(id, cowId), id);
    }

    public List<Vaccination> getAll(int cowId) {
        return repository.getAll(cowId);
    }

    public void delete(int id, int cowId) {
        checkNotFoundWithId(repository.delete(id, cowId), id);
    }

    public void update(Vaccination vaccination, int cowId) {
        Assert.notNull(vaccination, "vaccination must not be null");
        checkNotFoundWithId(repository.save(vaccination, cowId), vaccination.getId());
    }

    public Vaccination create(Vaccination vaccination, int cowId) {
        Assert.notNull(vaccination, "vaccination must not be null");
        return repository.save(vaccination, cowId);
    }
}
