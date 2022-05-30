package ua.vspelykh.dairyfarm.repository.record.calving;


import ua.vspelykh.dairyfarm.model.record.Calving;
import ua.vspelykh.dairyfarm.model.record.Insemination;

import java.util.List;

public interface CalvingRepository {

    Calving getOne(int id, int cowId);

    List<Calving> getAll(int cowId);

    List<Calving> getAllByFarmId(int farmId);


    Calving save(Calving calving, int cowId);

    boolean delete(int id, int cowId);
}
