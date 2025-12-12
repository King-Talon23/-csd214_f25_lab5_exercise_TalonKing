package TK.controllers;


import TK.entities.TicketEntity;
import TK.repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tickets")
public class TicketController {

    private final TicketEntityRepository ticketRepository;

    public TicketController(TicketEntityRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping
    public String getAllTickets(Model model) {
        List<TicketEntity> tickets = ticketRepository.findAll();
        model.addAttribute("tickets", tickets);
        return "ticketList";
    }
}