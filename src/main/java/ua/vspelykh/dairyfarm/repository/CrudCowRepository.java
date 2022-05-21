package ua.vspelykh.dairyfarm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.vspelykh.dairyfarm.model.Cow;

import javax.transaction.Transactional;

@Transactional
public interface CrudCowRepository extends JpaRepository<Cow, Integer> {


}
