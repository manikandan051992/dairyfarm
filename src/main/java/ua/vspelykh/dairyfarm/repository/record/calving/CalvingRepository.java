package ua.vspelykh.dairyfarm.repository.record.calving;


import ua.vspelykh.dairyfarm.model.record.Calving;

import java.util.List;

public interface CalvingRepository {

    Calving getOne(int id, int cowId);

    List<Calving> getAll(int cowId);

    Calving save(Calving calving, int cowId);

    boolean delete(int id, int cowId);
}
