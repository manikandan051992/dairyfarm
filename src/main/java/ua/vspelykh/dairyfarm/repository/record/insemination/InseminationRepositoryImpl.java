package ua.vspelykh.dairyfarm.repository.record.insemination;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.vspelykh.dairyfarm.model.record.Insemination;
import ua.vspelykh.dairyfarm.repository.cow.CrudCowRepository;

import java.util.List;

@Repository
public class InseminationRepositoryImpl implements InseminationRepository {

    private final CrudInseminationRepository inseminationRepository;
    private final CrudCowRepository cowRepository;

    public InseminationRepositoryImpl(CrudInseminationRepository inseminationRepository, CrudCowRepository cowRepository) {
        this.inseminationRepository = inseminationRepository;
        this.cowRepository = cowRepository;
    }


    @Override
    public Insemination getOne(int id, int cowId) {
        return inseminationRepository.findById(id)
                .filter(insemination -> insemination.getCow().getId() == cowId)
                .orElse(null);
    }

    @Override
    public List<Insemination> getAll(int cowId) {
        return inseminationRepository.getAll(cowId);
    }

    @Override
    public List<Insemination> getAllByFarmId(int farmId) {
        return inseminationRepository.getAllByFarmId(farmId);
    }

    @Transactional
    @Override
    public Insemination save(Insemination insemination, int cowId) {
        if (!insemination.isNew() && getOne(insemination.getId(), cowId) == null) {
            return null;
        }
        insemination.setCow(cowRepository.getReferenceById(cowId));
        return inseminationRepository.save(insemination);
    }

    @Override
    public boolean delete(int id, int cowId) {
        return inseminationRepository.delete(id, cowId) != 0;
    }
}
