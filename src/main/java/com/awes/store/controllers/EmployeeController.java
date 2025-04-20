package com.awes.store.controllers;

//Operations
//GET/ /employees
//POST /employees
//DELETE /employees/{id}

import com.awes.store.dto.EmployeeDTO;
import com.awes.store.services.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    @GetMapping(path = "/employees")
//    public EmployeeDTO getEmployees() {
//        return new EmployeeDTO(6l, "Awesuddin", LocalDate.of(2025, 6,06), true);
//    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/{id}")
    public EmployeeDTO getEmployees(@PathVariable("id") Long employeeId) { // you must pass the id it is required
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createNewEmployee(employeeDTO);
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteEmployeeById(@PathVariable Long id) {
        return employeeService.deleteEmployeeById(id);
    }

//    @GetMapping(path = "/employees/{id}")
//    public EmployeeDTO getEmployees(@PathVariable("id") Long employeeId) { // you must pass the id it is required
//        return new EmployeeDTO(employeeId, "Awesuddin", LocalDate.of(2025, 6,06), true);
//    }

//    @GetMapping
//    public String  getEmployees(@PathParam("sortBy") String sortBy) { //here it is optional to pass param http://localhost:8080/employees?sortBy=example
//        return "Hello "+ sortBy;
//    }
}
