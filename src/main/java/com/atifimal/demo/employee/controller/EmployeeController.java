package com.atifimal.demo.employee.controller;

import com.atifimal.demo.employee.entity.Employee;
import com.atifimal.demo.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @GetMapping("all")
    public ResponseEntity<List<Employee>> getAll() {
        return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
    }
}