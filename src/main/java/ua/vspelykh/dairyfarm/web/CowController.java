package ua.vspelykh.dairyfarm.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.vspelykh.dairyfarm.model.entity.Cow;
import ua.vspelykh.dairyfarm.service.CowService;
import ua.vspelykh.dairyfarm.util.SecurityUtil;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cows")
public class CowController {

    private final CowService cowService;

    public CowController(CowService cowService) {
        this.cowService = cowService;
    }


    @GetMapping
    public ResponseEntity<List<Cow>> getAllCows(
            @RequestParam(required = false) String number,
            @RequestParam(required = false) Integer section) {

        List<Cow> cows = cowService.getAll(SecurityUtil.getAuthFarmId());
        cows = cows.stream().filter(cow -> number == null || cow.getNumber().contains(number))
                .filter(cow -> section == null || cow.getSection().equals(section))
                .toList();
        return new ResponseEntity<>(cows, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public String getCow(Model model, @PathVariable String id){
        Cow cow = cowService.get(Integer.parseInt(id), SecurityUtil.getAuthFarmId());
        model.addAttribute("cow", cowService.getWithFullInfo(cow.getId(), cow.getFarm().getId()));
        return "cowInfo";
    }
}
