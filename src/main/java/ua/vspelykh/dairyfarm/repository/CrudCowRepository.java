package ua.vspelykh.dairyfarm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.vspelykh.dairyfarm.model.entity.Cow;

import javax.transaction.Transactional;

@Transactional
public interface CrudCowRepository extends JpaRepository<Cow, Integer> {


}
