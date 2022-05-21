package ua.vspelykh.dairyfarm.repository;

import org.springframework.stereotype.Repository;
import ua.vspelykh.dairyfarm.model.Cow;

import java.util.List;

public interface CowRepository {

    Cow getOne(int id);

    List<Cow> getAll();

    Cow save(Cow cow);

    boolean delete(int id);
}
