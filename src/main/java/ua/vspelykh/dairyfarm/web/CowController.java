package ua.vspelykh.dairyfarm.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.vspelykh.dairyfarm.service.CowService;

@Controller
@RequestMapping("/cows")
public class CowController {

    private final CowService cowService;

    public CowController(CowService cowService) {
        this.cowService = cowService;
    }


    @GetMapping
    public String cows(Model model) {
        model.addAttribute("cows", cowService.getAll());
        return "cows.html";
    }
}
