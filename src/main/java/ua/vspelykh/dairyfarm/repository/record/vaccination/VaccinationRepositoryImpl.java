package ua.vspelykh.dairyfarm.repository.record.vaccination;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.vspelykh.dairyfarm.model.record.Vaccination;
import ua.vspelykh.dairyfarm.repository.cow.CrudCowRepository;

import java.util.List;

@Repository
public class VaccinationRepositoryImpl implements VaccinationRepository{

    private final CrudVaccinationRepository vaccinationRepository;
    private CrudCowRepository cowRepository;

    public VaccinationRepositoryImpl(CrudVaccinationRepository vaccinationRepository, CrudCowRepository cowRepository) {
        this.vaccinationRepository = vaccinationRepository;
        this.cowRepository = cowRepository;
    }

    @Override
    public Vaccination getOne(int id, int cowId) {
        return vaccinationRepository.findById(id)
                .filter(vaccination -> vaccination.getCow().getId() == cowId)
                .orElse(null);
    }

    @Override
    public List<Vaccination> getAll(int cowId) {
        return vaccinationRepository.getAll(cowId);
    }

    @Transactional
    @Override
    public Vaccination save(Vaccination vaccination, int cowId) {
        if (!vaccination.isNew() && getOne(vaccination.getId(), cowId) == null) {
            return null;
        }
        vaccination.setCow(cowRepository.getReferenceById(cowId));
        return vaccinationRepository.save(vaccination);
    }

    @Override
    public boolean delete(int id, int cowId) {
        return vaccinationRepository.delete(id, cowId) != 0;
    }
}
