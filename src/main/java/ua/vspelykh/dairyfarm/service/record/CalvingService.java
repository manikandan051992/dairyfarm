package ua.vspelykh.dairyfarm.service.record;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ua.vspelykh.dairyfarm.model.record.Calving;
import ua.vspelykh.dairyfarm.model.record.Insemination;
import ua.vspelykh.dairyfarm.repository.record.calving.CalvingRepository;
import ua.vspelykh.dairyfarm.repository.record.insemination.InseminationRepository;

import java.util.List;

import static ua.vspelykh.dairyfarm.util.ValidationUtil.checkNotFoundWithId;

@Service
public class CalvingService {

    private final CalvingRepository repository;

    public CalvingService(CalvingRepository repository) {
        this.repository = repository;
    }


    public Calving get(int id, int cowId) {
        return checkNotFoundWithId(repository.getOne(id, cowId), id);
    }

    public List<Calving> getAll(int cowId) {
        return repository.getAll(cowId);
    }

    public void delete(int id, int cowId) {
        checkNotFoundWithId(repository.delete(id, cowId), id);
    }

    public void update(Calving calving, int cowId) {
        Assert.notNull(calving, "calving must not be null");
        checkNotFoundWithId(repository.save(calving, cowId), calving.getId());
    }

    public Calving create(Calving calving, int cowId) {
        Assert.notNull(calving, "calving must not be null");
        return repository.save(calving, cowId);
    }
}

