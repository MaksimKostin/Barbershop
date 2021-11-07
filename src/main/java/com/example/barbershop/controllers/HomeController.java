package com.example.barbershop.controllers;

import com.example.barbershop.models.EmailForm;
import com.example.barbershop.models.ReportForm;
import com.example.barbershop.repository.EmailRepository;
import com.example.barbershop.repository.ReportRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    private final ReportRepository reportRepository;
    private final EmailRepository emailRepository;

    public HomeController(ReportRepository reportRepository, EmailRepository emailRepository) {
        this.reportRepository = reportRepository;
        this.emailRepository = emailRepository;
    }

    // Главная страница
    @GetMapping("/index")
    public String index(@ModelAttribute("reportForm") ReportForm reportForm,
                        @ModelAttribute("emailForm") EmailForm emailForm) {
        return "index";
    }

    // Создание сообщения на главной странице
    @PostMapping("/report")
    public String createReport(@ModelAttribute("reportForm") @Valid ReportForm reportForm,
                               BindingResult bindingResult,
                               @ModelAttribute("emailForm") EmailForm emailForm) {

        if(bindingResult.hasErrors())
            return "index";

        reportRepository.save(reportForm);
        return "redirect:/index";
    }

    // Подписка на рассылку для главной страницы
    @PostMapping("/news")
    public String saveEmail(@ModelAttribute("reportForm") ReportForm reportForm,
                            @ModelAttribute("emailForm") @Valid EmailForm emailForm,
                            BindingResult bindingResult) {

        if(bindingResult.hasErrors())
            return "index";

        emailRepository.saveEmail(emailForm.getEmail());
        return "redirect:/index";
    }

}
