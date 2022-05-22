package ua.vspelykh.dairyfarm.repository.record.calving;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.vspelykh.dairyfarm.model.record.Calving;
import ua.vspelykh.dairyfarm.repository.cow.CrudCowRepository;

import java.util.List;

@Repository
public class CalvingRepositoryImpl implements CalvingRepository{

    private final CrudCalvingRepository calvingRepository;
    private final CrudCowRepository cowRepository;

    public CalvingRepositoryImpl(CrudCalvingRepository calvingRepository, CrudCowRepository cowRepository) {
        this.calvingRepository = calvingRepository;
        this.cowRepository = cowRepository;
    }


    @Override
    public Calving getOne(int id, int cowId) {
        return calvingRepository.findById(id)
                .filter(calving -> calving.getCow().getId() == cowId)
                .orElse(null);
    }

    @Override
    public List<Calving> getAll(int cowId) {
        return calvingRepository.getAll(cowId);
    }

    @Transactional
    @Override
    public Calving save(Calving calving, int cowId) {
        if (!calving.isNew() && getOne(calving.getId(), cowId) == null) {
            return null;
        }
        calving.setCow(cowRepository.getReferenceById(cowId));
        return calvingRepository.save(calving);
    }

    @Override
    public boolean delete(int id, int cowId) {
        return calvingRepository.delete(id, cowId) != 0;
    }
}
