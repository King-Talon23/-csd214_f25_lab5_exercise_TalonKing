package TK.controllers;


import TK.entities.MagazineEntity;
import TK.repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/magazines")
public class MagazineController {

    private final MagazineEntityRepository magazineRepository;

    public MagazineController(MagazineEntityRepository magazineRepository) {
        this.magazineRepository = magazineRepository;
    }

    @GetMapping
    public String getAllMagazines(Model model) {
        List<MagazineEntity> magazines = magazineRepository.findAll();
        model.addAttribute("magazines", magazines);
        return "magazineList";
    }
}