package com.VotingSystem.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.VotingSystem.entity.Voter;
import com.VotingSystem.service.VoterService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class VoterController {

   
    @Autowired
    private VoterService voterService;
       
   @GetMapping("/saveVoter")
    public String saveVoter(Model model) {
        model.addAttribute("voter", new Voter());
        return "voterRegister";
    }

    @PostMapping("/goVoterRegister")
    public String getVoterStatus(@Valid @ModelAttribute Voter voter, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "voterRegister";
        }
        voterService.saveVoter(voter);
        return "redirect:/voterlogin";
    }

    @GetMapping("/voterlogin")
    public String showLoginForm(Model model) {
        model.addAttribute("voter", new Voter());
        return "voterlogin";
    }

    @PostMapping("/voterlogin")
    public String login(@ModelAttribute Voter voter, Model model) {
        Voter existingVoter = voterService.findVoterByUsernameAndPassword(voter.getUsername(), voter.getPassword());
        if (existingVoter != null) {
            return "VoterDashboard";
        } else {
            model.addAttribute("loginError", "Invalid username or password");
            return "voterlogin";
        }
    }
    
    @GetMapping("/viewVoters")
    public String viewVoters(Model model) {
        List<Voter> voters = voterService.getAllVoters();
        model.addAttribute("voters", voters);
        return "viewVoters";
    }
    
    @DeleteMapping("/viewVoters/{id}")
    public String deleteVoter(@PathVariable int id) {
        voterService.deleteVoterById(id);
        return "redirect:/viewVoters";
    }
    
    @RequestMapping("/VoterDashboard")
    public String VoterDashboard() {
        
        return "VoterDashboard"; 
    }
    

   
}
