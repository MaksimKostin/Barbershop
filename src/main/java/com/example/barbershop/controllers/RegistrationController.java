package com.example.barbershop.controllers;

import com.example.barbershop.models.Role;
import com.example.barbershop.models.User;
import com.example.barbershop.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RegistrationController {

    private final UserRepository userRepository;

    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/registration")
    public String registration(@RequestParam(value = "error", required = false) String error, Model model) {
        return "registration";
    }


    @PostMapping("/registration")
    public String addUser(User user) {
        if(userRepository.existsByUsername(user.getUsername())){
            return "redirect:/registration?error";
        }
        user.setActive(true);
        user.setRole(Role.USER);
        userRepository.save(user);
        return "redirect:/login";
    }
}
