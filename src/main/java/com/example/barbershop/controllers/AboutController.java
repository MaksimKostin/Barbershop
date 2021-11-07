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
public class AboutController {

    private final EmailRepository emailRepository;

    public AboutController(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    // Страница "О нас"
    @GetMapping("/about")
    public String about(@ModelAttribute("emailForm") EmailForm emailForm) { return "about"; }

    // Подписка на рассылку для страницы "О нас"
    @PostMapping("/about")
    public String saveEmail(@ModelAttribute("emailForm") @Valid EmailForm emailForm,
                        BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "about";

        emailRepository.saveEmail(emailForm.getEmail());
        return "redirect:/about";
    }
}
