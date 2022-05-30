package ua.vspelykh.dairyfarm.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.vspelykh.dairyfarm.model.entity.Farm;
import ua.vspelykh.dairyfarm.service.CowService;
import ua.vspelykh.dairyfarm.service.FarmService;
import ua.vspelykh.dairyfarm.service.UserService;
import ua.vspelykh.dairyfarm.util.SecurityUtil;

import java.util.List;

@Controller
@RequestMapping
public class FarmController {

    private final FarmService farmService;
    private final CowService cowService;
    private final UserService userService;

    public FarmController(FarmService farmService, CowService cowService, UserService userService) {
        this.farmService = farmService;
        this.cowService = cowService;
        this.userService = userService;
    }

    @GetMapping("farms")
    public String farms(Model model){
        List<Farm> all = farmService.getAll();
        model.addAttribute("farms", all);
        return "farms";
    }

    @GetMapping("farm")
    public String farm(Model model){
        model.addAttribute("farm", farmService.get(SecurityUtil.getAuthFarmId()));
        model.addAttribute("cows", cowService.getAll(SecurityUtil.getAuthFarmId()));
        return "farmPage";
    }
}
