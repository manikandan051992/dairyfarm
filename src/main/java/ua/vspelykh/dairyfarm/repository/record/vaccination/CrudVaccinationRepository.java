package ua.vspelykh.dairyfarm.repository.record.vaccination;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ua.vspelykh.dairyfarm.model.record.Insemination;
import ua.vspelykh.dairyfarm.model.record.Vaccination;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudVaccinationRepository extends JpaRepository<Vaccination, Integer> {

    @Query("SELECT v FROM Vaccination v WHERE v.cow.id=:cowId ORDER BY v.date DESC")
    List<Vaccination> getAll(@Param("cowId") int cowId);

    @Query("SELECT v FROM Vaccination v WHERE v.cow.farm.id=:farmId")
    List<Vaccination> getAllByFarmId(int farmId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Vaccination v WHERE v.id=:id AND v.cow.id=:cowId")
    int delete(@Param("id") int id, @Param("cowId") int cowId);
}
