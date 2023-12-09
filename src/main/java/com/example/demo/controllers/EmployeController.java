package com.example.demo.controllers;


import com.example.demo.entities.Employe;
import com.example.demo.entities.Machine;
import com.example.demo.repositories.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class EmployeController {
    @Autowired
    private EmployeRepository employeRepository;


    @GetMapping("/employes")
    public String showForm(Model model) {
        model.addAttribute("employes", employeRepository.findAll());
        return "ListEmployes";
    }
    @GetMapping("/employees")
    @ResponseBody
    public ResponseEntity<List<String>> getAllEmployeesNamesJson() {
        List<String> employeeNames = employeRepository.findAllEmployeeNames();
        return new ResponseEntity<>(employeeNames, HttpStatus.OK);
    }



    @GetMapping("/signup-employe")
    public String showSignUpForm(Employe employe) {
        return "add-employe";
    }

    @PostMapping("/addemploye")
    public String addEmploye(Employe employe, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-employe";
        }

        employeRepository.save(employe);
        model.addAttribute("employes", employeRepository.findAll());
        return "ListEmployes";
    }

    @GetMapping("/edit-employe/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Employe employe = employeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employe Id:" + id));
        model.addAttribute("employe", employe);
        return "update-employe";
    }

    @PostMapping("/update-employe/{id}")
    public String updateEmploye(@PathVariable("id") long id, Employe employe, BindingResult result, Model model) {
        if (result.hasErrors()) {
            employe.setId(id);
            return "update-employe";
        }

        employeRepository.save(employe);
        model.addAttribute("employes", employeRepository.findAll());
        return "ListEmployes";
    }

    @GetMapping("/delete-employe/{id}")
    public String deleteEmploye(@PathVariable("id") long id, Model model) {
        Employe employe = employeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employe Id:" + id));
        employeRepository.delete(employe);
        model.addAttribute("employes", employeRepository.findAll());
        return "ListEmployes";
    }







    @GetMapping("/Count")
    public ResponseEntity<List<Map<String, Object>>> showMachineChartForAllEmployees() {
        List<Object[]> machinesByEmployees = employeRepository.getMachineCountByEmployee();

        // Create a list to store JSON objects for each employee
        List<Map<String, Object>> employeeMachineList = new ArrayList<>();

        for (Object[] row : machinesByEmployees) {
            String employeeName = (String) row[0];
            Long machineCount = (Long) row[1];

            // Create a JSON object for each employee
            Map<String, Object> employeeMachineMap = new HashMap<>();
            employeeMachineMap.put("employeeName", employeeName);
            employeeMachineMap.put("machineCount", machineCount);

            employeeMachineList.add(employeeMachineMap);
        }

        return new ResponseEntity<>(employeeMachineList, HttpStatus.OK);

    }


    @GetMapping("/graph")
    public String showMachineChartPage() {
        return "graph";
    }


}
