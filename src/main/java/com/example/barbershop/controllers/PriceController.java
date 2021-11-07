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
public class PriceController {

    private final EmailRepository emailRepository;

    public PriceController(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    // Страница "Прайс"
    @GetMapping("/price")
    public String price(@ModelAttribute("emailForm") EmailForm emailForm) {
        return "price";
    }

    // Подписка на рассылку для страницы "Прайс"
    @PostMapping("/price")
    public String saveEmail(@ModelAttribute("emailForm") @Valid EmailForm emailForm,
                        BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "price";

        emailRepository.saveEmail(emailForm.getEmail());
        return "redirect:/price";
    }
}
