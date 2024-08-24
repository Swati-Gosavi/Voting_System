package com.VotingSystem.controller;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.VotingSystem.entity.Election;
import com.VotingSystem.service.ElectionService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class ElectionController {

    @Autowired
    private ElectionService electionService;

    // Display the form to add a new election
    @GetMapping("/addElections")
    public String showAddElectionForm(Model model) {
        model.addAttribute("election", new Election());
        return "addElection"; // This corresponds to addElection.html
    }

    // Handle the submission of the new election form
    @PostMapping("/goAddElections")
    public String addElection(@Valid @ModelAttribute Election election, BindingResult bindingResult) {
    	if (bindingResult.hasErrors()) {
            return "addElection";
        }
        electionService.saveElection(election);
        return "redirect:/view"; // Redirect to the list of elections
    }

   
    // Display the list of all elections
    @GetMapping("/viewElection")
    public String viewElections(Model model) {
    	List<Election> elections =  electionService.getAllElections();
        model.addAttribute("elections", elections);
        return "viewElections"; // This corresponds to viewElections.html
    }

    // Handle the deletion of an election by its ID
    @DeleteMapping("/viewElections/{id}")
    public String deleteElection(@PathVariable int id) {
        electionService.deleteElectionById(id);
        return "redirect:/viewElection"; // Redirect to the list of elections after deletion
    }
    
    @GetMapping("/viewElectionsForVoter")
    public String viewElectionsForVoter(Model model) {
    	List<Election> elections =  electionService.getAllElections();
        model.addAttribute("elections", elections);
        return "viewElectionsForVoter"; // This corresponds to viewElections.html
    }
    
  
}
