package ua.vspelykh.dairyfarm.service;

import org.springframework.stereotype.Service;
import ua.vspelykh.dairyfarm.model.entity.Cow;
import ua.vspelykh.dairyfarm.repository.CowRepository;

import java.util.List;

@Service
public class CowService {

    private final CowRepository cowRepository;

    public CowService(CowRepository cowRepository) {
        this.cowRepository = cowRepository;
    }

    public Cow getOne(int id){
        return cowRepository.getOne(id);
    }

    public List<Cow> getAll(){
        return cowRepository.getAll();
    }

    public Cow save(Cow cow){
        return cowRepository.save(cow);
    }

    public boolean delete(int id){
        return cowRepository.delete(id);
    }
}
