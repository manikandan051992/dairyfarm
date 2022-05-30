package ua.vspelykh.dairyfarm.service.record;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ua.vspelykh.dairyfarm.model.entity.Cow;
import ua.vspelykh.dairyfarm.model.record.Insemination;
import ua.vspelykh.dairyfarm.repository.record.insemination.InseminationRepository;

import java.util.List;

import static ua.vspelykh.dairyfarm.util.ValidationUtil.checkNotFoundWithId;

@Service
public class InseminationService {

    private final InseminationRepository repository;

    public InseminationService(InseminationRepository repository) {
        this.repository = repository;
    }

    public Insemination get(int id, int cowId){
        return checkNotFoundWithId(repository.getOne(id, cowId), id);
    }

    public List<Insemination> getAll(int cowId){
        return repository.getAll(cowId);
    }

    public void delete(int id, int cowId) {
        checkNotFoundWithId(repository.delete(id, cowId), id);
    }

    public void update(Insemination insemination, int cowId) {
        Assert.notNull(insemination, "insemination must not be null");
        checkNotFoundWithId(repository.save(insemination, cowId), insemination.getId());
    }

    public Insemination create(Insemination insemination, int cowId) {
        Assert.notNull(insemination, "insemination must not be null");
        return repository.save(insemination, cowId);
    }
}
