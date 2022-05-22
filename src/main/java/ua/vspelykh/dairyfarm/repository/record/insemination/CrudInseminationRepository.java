package ua.vspelykh.dairyfarm.repository.record.insemination;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ua.vspelykh.dairyfarm.model.record.Insemination;

import java.util.List;

public interface CrudInseminationRepository extends JpaRepository<Insemination, Integer> {


    @Query("SELECT i FROM Insemination i WHERE i.cow.id=:cowId ORDER BY i.date DESC")
    List<Insemination> getAll(@Param("cowId") int cowId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Insemination i WHERE i.id=:id AND i.cow.id=:cowId")
    int delete(@Param("id") int id, @Param("cowId") int cowId);
}
