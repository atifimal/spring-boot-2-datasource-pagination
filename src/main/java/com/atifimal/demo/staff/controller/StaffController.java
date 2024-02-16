package com.atifimal.demo.staff.controller;

import com.atifimal.demo.staff.entity.Staff;
import com.atifimal.demo.staff.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("staff")
public class StaffController {

    private final StaffRepository staffRepository;

    @GetMapping("all")
    public ResponseEntity<List<Staff>> getAll() {
        return new ResponseEntity<>(staffRepository.findAll(), HttpStatus.OK);
    }
}
