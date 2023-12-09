package com.example.demo.controllers;

import com.example.demo.entities.Admin;
import com.example.demo.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {


        @Autowired
        private AdminRepository adminRepository;

        @GetMapping("/")
        public String loginForm() {
            return "login";
        }

        @PostMapping("/login")
        public String loginSubmit(@RequestParam String userName, @RequestParam String password, Model model) {
            Admin admin = adminRepository.findByUserName(userName);

            if (admin != null && admin.getPassword().equals(password)  && admin.getUserName().equals(userName)) {
                // Authentification réussie, rediriger vers la page principale
                return "index";
            } else {
                // Authentification échouée, afficher un message d'erreur
                model.addAttribute("error", "Invalid credentials. Please try again.");
                return "login";
            }
        }


}
