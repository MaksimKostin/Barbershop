package com.example.barbershop.controllers;

import com.example.barbershop.models.Report;
import com.example.barbershop.repository.ReportRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/barbershop")
public class ClientController {

    private final ReportRepository reportRepository;

    public ClientController(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @GetMapping("/index")
    public String index(@ModelAttribute("report") Report report) {
        return "index";
    }

    @GetMapping("/about")
    public String about() { return "about"; }

    @GetMapping("/service")
    public String service() {
        return "service";
    }

    @GetMapping("/price")
    public String price() {
        return "price";
    }

    @PostMapping("/index")
    public String createReport(@ModelAttribute("report") @Valid Report report,
                                BindingResult bindingResult) {

        if(bindingResult.hasErrors())
            return "index";

        reportRepository.save(report);
        return "redirect:/barbershop/index";
    }
}
