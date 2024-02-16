package com.atifimal.demo.stuff.controller;

import com.atifimal.demo.stuff.entity.Stuff;
import com.atifimal.demo.stuff.repository.StuffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("stuff")
public class StuffController {

    private final StuffRepository stuffRepository;

    @GetMapping("all")
    public ResponseEntity<List<Stuff>> getAll() {
        return new ResponseEntity<>(stuffRepository.findAll(), HttpStatus.OK);
    }
}
