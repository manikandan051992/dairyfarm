package ua.vspelykh.dairyfarm.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.vspelykh.dairyfarm.model.entity.Cow;
import ua.vspelykh.dairyfarm.service.CowService;
import ua.vspelykh.dairyfarm.util.SecurityUtil;

import java.util.List;

@RestController("rest/cows")
public class CowRestController {

    private final CowService cowService;

    public CowRestController(CowService cowService) {
        this.cowService = cowService;
    }

    @GetMapping
    public ResponseEntity<List<Cow>> get(){
        return new ResponseEntity<>(cowService.getAll(SecurityUtil.getAuthFarmId()), HttpStatus.OK);
    }
}
