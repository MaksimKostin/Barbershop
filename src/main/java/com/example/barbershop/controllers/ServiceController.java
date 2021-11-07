package com.example.barbershop.controllers;

import com.example.barbershop.models.EmailForm;
import com.example.barbershop.repository.EmailRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ServiceController {

    private final EmailRepository emailRepository;

    public ServiceController(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    // Страница "Сервис"
    @GetMapping("/service")
    public String service(@ModelAttribute("emailForm") EmailForm emailForm) {
        return "service";
    }

    // Подписка на рассылку для страницы "Сервис"
    @PostMapping("/service")
    public String saveEmail(@ModelAttribute("emailForm") @Valid EmailForm emailForm,
                          BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "service";

        emailRepository.saveEmail(emailForm.getEmail());
        return "redirect:/service";
    }
}
