package ua.vspelykh.dairyfarm.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.vspelykh.dairyfarm.model.entity.Cow;
import ua.vspelykh.dairyfarm.model.record.Calving;
import ua.vspelykh.dairyfarm.model.record.Insemination;
import ua.vspelykh.dairyfarm.model.record.Vaccination;
import ua.vspelykh.dairyfarm.service.CowService;
import ua.vspelykh.dairyfarm.service.record.CalvingService;
import ua.vspelykh.dairyfarm.service.record.InseminationService;
import ua.vspelykh.dairyfarm.service.record.VaccinationService;
import ua.vspelykh.dairyfarm.util.SecurityUtil;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cows")
public class CowController {

    private final CowService cowService;
    private final InseminationService inseminationService;
    private final CalvingService calvingService;
    private final VaccinationService vaccinationService;

    public CowController(CowService cowService, InseminationService inseminationService,
                         CalvingService calvingService, VaccinationService vaccinationService) {
        this.cowService = cowService;
        this.inseminationService = inseminationService;
        this.calvingService = calvingService;
        this.vaccinationService = vaccinationService;
    }

    @GetMapping
    public String getAllCows(Model model, String number, Integer section) {

        List<Cow> cows = cowService.getAll(SecurityUtil.getAuthFarmId());
        cows = cows.stream().filter(cow -> number == null || cow.getNumber().contains(number))
                .filter(cow -> section == null || cow.getSection().equals(section))
                .toList();
        model.addAttribute("cows", cows);
        return "cows";
    }

    @GetMapping("/{id}")
    public String getCow(Model model, @PathVariable String id){
        Cow cow = cowService.getWithFullInfo(Integer.parseInt(id), SecurityUtil.getAuthFarmId());
        List<Insemination> inseminations = inseminationService.getAll(Integer.parseInt(id));
        List<Vaccination> vaccinations = vaccinationService.getAll(Integer.parseInt(id));
        List<Calving> calvings = calvingService.getAll(Integer.parseInt(id));
        model.addAttribute("cow", cowService.getWithFullInfo(cow.getId(), cow.getFarm().getId()));
        model.addAttribute("inseminations", inseminations);
        model.addAttribute("calvings", calvings);
        model.addAttribute("vaccinations", vaccinations);

        return "cowInfo";
    }
}