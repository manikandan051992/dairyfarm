package ua.vspelykh.dairyfarm.repository.record.insemination;

import ua.vspelykh.dairyfarm.model.record.Insemination;

import java.util.List;

public interface InseminationRepository {

    Insemination getOne(int id, int cowId);

    List<Insemination> getAll(int cowId);

    Insemination save(Insemination insemination, int cowId);

    boolean delete(int id, int cowId);
}
