package com.VotingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.VotingSystem.entity.Admin;
import com.VotingSystem.service.AdminService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class AdminController {
   

    @Autowired
    private AdminService adminService;

    
   

    @GetMapping("/saveAdmin")
    public String saveAdmin(Model model) {
        model.addAttribute("admin", new Admin());
        return "adminregister";
       
    }

    @PostMapping("/goadminregister")
    public String getAdminStatus(@Valid @ModelAttribute Admin admin, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "adminregister";
        }
        adminService.saveAdmin(admin);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "adminlogin";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Admin admin, Model model) {
        Admin existingAdmin = adminService.findAdminByUsernameAndPassword(admin.getUsername(), admin.getPassword());
        if (existingAdmin != null) {
            return "index";
        } else {
            model.addAttribute("loginError", "Invalid username or password");
            return "adminlogin";
        }
    }
    
    @RequestMapping("/")
    public String AdminDashboard() {
        
        return "index"; 
    }


}
