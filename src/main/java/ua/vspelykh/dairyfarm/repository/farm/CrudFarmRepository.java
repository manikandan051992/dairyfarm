package ua.vspelykh.dairyfarm.repository.farm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ua.vspelykh.dairyfarm.model.entity.Farm;


@Transactional
public interface CrudFarmRepository extends JpaRepository<Farm, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Farm f WHERE f.id=:id")
    int delete(@Param("id") int id);

    Farm getByEmail(String email);
}
