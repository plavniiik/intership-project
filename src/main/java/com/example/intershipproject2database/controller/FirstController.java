package com.example.intershipproject2database.controller;

import com.example.intershipproject2database.entity.dbone.Indicators;
import com.example.intershipproject2database.repositories.dbone.FirstIndicatorsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/indicators")
public class FirstController {

    private final FirstIndicatorsRepository firstRepository;

    @PostMapping
    public ResponseEntity<Indicators> create(@RequestBody Indicators indicators) {
        return ResponseEntity.ok(firstRepository.save(indicators));
    }

    @GetMapping("{id}")
    public ResponseEntity<Indicators> getById(@PathVariable Long id) {
        return ResponseEntity.ok(firstRepository.findById(id).orElseThrow());
    }

    @DeleteMapping("{id}")
    public HttpStatus delete(@PathVariable Long id) {
        firstRepository.deleteById(id);
        return HttpStatus.OK;
    }

}