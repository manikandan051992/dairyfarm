package ua.vspelykh.dairyfarm.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.vspelykh.dairyfarm.model.entity.Farm;
import ua.vspelykh.dairyfarm.service.FarmService;

import java.util.List;

@Controller
@RequestMapping("/farms")
public class FarmController {

    private final FarmService farmService;

    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    @GetMapping
    public String farms(Model model){
        List<Farm> all = farmService.getAll();
        model.addAttribute("farms", all);
        return "farms";
    }
}
