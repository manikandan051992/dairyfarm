package ua.vspelykh.dairyfarm.repository.record.calving;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ua.vspelykh.dairyfarm.model.record.Calving;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudCalvingRepository extends JpaRepository<Calving, Integer> {

    @Query("SELECT c FROM Calving c  WHERE c.cow.id=:cowId ORDER BY c.date DESC")
    List<Calving> getAll(@Param("cowId") int cowId);

    @Query("SELECT c FROM Calving c WHERE c.cow.farm.id=:farmId")
    List<Calving> getAllByFarmId(@Param("farmId") int farmId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Calving c WHERE c.id=:id AND c.cow.id=:cowId")
    int delete(@Param("id") int id, @Param("cowId") int cowId);

}
