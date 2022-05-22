package ua.vspelykh.dairyfarm.repository.record.vaccine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.vspelykh.dairyfarm.model.record.Vaccine;

@Transactional(readOnly = true)
@Repository
public interface CrudVaccineRepository extends JpaRepository<Vaccine, Integer> {
}
