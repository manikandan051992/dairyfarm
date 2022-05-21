package ua.vspelykh.dairyfarm.repository;

import ua.vspelykh.dairyfarm.model.entity.Cow;

import java.util.List;

public interface CowRepository {

    Cow getOne(int id);

    List<Cow> getAll();

    Cow save(Cow cow);

    boolean delete(int id);
}
