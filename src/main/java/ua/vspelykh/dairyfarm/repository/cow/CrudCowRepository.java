package ua.vspelykh.dairyfarm.repository.cow;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ua.vspelykh.dairyfarm.model.entity.Cow;

import java.util.List;


@Transactional(readOnly = true)
public interface CrudCowRepository extends JpaRepository<Cow, Integer> {

    @Query("SELECT c FROM Cow c WHERE c.farm.id=:farmId ORDER BY c.birth DESC")
    List<Cow> getAllByFarmId(@Param("farmId") int farmId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Cow c WHERE c.id=?1 AND  c.farm.id=?2")
    int delete(@Param("id") int id, @Param("farmId") int farmId);


    @EntityGraph(value = "cow.full", type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT c FROM Cow c WHERE c.id=?1 AND c.farm.id=?2")
    Cow getCowWithFullInfo(int id, int farmId);

}