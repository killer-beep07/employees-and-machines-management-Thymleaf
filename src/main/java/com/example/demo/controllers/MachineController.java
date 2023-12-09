package com.example.demo.controllers;




import com.example.demo.entities.Employe;
import com.example.demo.entities.Machine;
import com.example.demo.repositories.EmployeRepository;
import com.example.demo.repositories.MachineRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.TemporalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class MachineController {
    @Autowired
    private MachineRepository machineRepository;
    @Autowired
    private EmployeRepository employeRepository;

    @GetMapping("/machines")
    public String showForm(Model model) {
        model.addAttribute("machines", machineRepository.findAll());
        return "ListeMachines";
    }


    @GetMapping("/signup-machine")
    public String showSignUpForm(Machine machine) {
        return "add-machine";
    }

    @PostMapping("/addmachine")
    public String addMachine(Machine machine, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-machine";
        }

        machineRepository.save(machine);
        model.addAttribute("machines", machineRepository.findAll());
        return "ListeMachines";
    }


    @GetMapping("/edit-machine/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Machine machine = machineRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid machine Id:" + id));
        model.addAttribute("machine", machine);
        return "update-machine";
    }
    @PostMapping("/update-machine/{id}")
    public String updateMachine(@PathVariable("id") long id, Machine machine, BindingResult result, Model model) {
        if (result.hasErrors()) {
            machine.setId(id);
            return "update-machine";
        }

        machineRepository.save(machine);
        model.addAttribute("machines", machineRepository.findAll());
        return "ListeMachines";
    }

    @GetMapping("/delete-machine/{id}")
    public String deleteMachine(@PathVariable("id") long id, Model model) {
        Machine machine = machineRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid machine Id:" + id));
        machineRepository.delete(machine);
        model.addAttribute("machines", machineRepository.findAll());
        return "ListeMachines";
    }

@GetMapping("/filtrage")
public String showAssignMachinesToEmployeeForm(Model model) {
    // Ajouter la liste des employés au modèle
    model.addAttribute("employees", employeRepository.findAll());
    return "filtrage";
}



@PostMapping("/filtrage")
public ResponseEntity<String> assignMachinesToEmployee(@RequestParam Long employeeId, Model model) {
    // Récupérer les machines assignées à l'employé sélectionné
    List<Machine> machines = machineRepository.findByEmployeId(employeeId);

    // Convertir la liste de machines en JSON
    ObjectMapper objectMapper = new ObjectMapper();
    try {
        String machinesJson = objectMapper.writeValueAsString(machines);

        // Retourner la réponse JSON
        return new ResponseEntity<>(machinesJson, HttpStatus.OK);
    } catch (JsonProcessingException e) {
        e.printStackTrace();
        return new ResponseEntity<>("Error processing JSON", HttpStatus.INTERNAL_SERVER_ERROR);
    }


}


//    @GetMapping("/annee-achat")
//    public ResponseEntity<Map<Integer, Long>> getNombreMachinesParAnnee() {
//        List<Machine> machines = (List<Machine>) machineRepository.findAll();
//
//        // Utiliser Java Streams pour obtenir une Map avec l'année d'achat et le nombre de machines
//        Map<Integer, Long> nombreMachinesParAnnee = machines.stream()
//                .collect(Collectors.groupingBy(
//                        machine -> {
//                            LocalDate dateAchat = machine.getDateAchat();
//                            return (dateAchat != null) ? dateAchat.getYear() : null;
//                        },
//                        Collectors.counting()
//                ));
//
//        // Retourner la Map en tant que réponse JSON
//        return new ResponseEntity<>(nombreMachinesParAnnee, HttpStatus.OK);
//    }
//
//
//    @GetMapping("/graph2")
//    public String showGraphPage() {
//        return "graph2";
//    }


}







