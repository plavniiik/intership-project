package com.example.intershipproject2database.controller;


import com.example.intershipproject2database.entity.dbtwo.Indicators2;
import com.example.intershipproject2database.repositories.dbtwo.SecondIndicators2Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/indicators2")
public class SecondController {

    private final SecondIndicators2Repository secondRepository;

    @PostMapping
    public ResponseEntity<Indicators2> create(@RequestBody Indicators2 indicators2) {
        return ResponseEntity.ok(secondRepository.save(indicators2));
    }

    @GetMapping("{id}")
    public ResponseEntity<Indicators2> getById(@PathVariable Long id) {
        return ResponseEntity.ok(secondRepository.findById(id).orElseThrow());
    }

    @DeleteMapping("{id}")
    public HttpStatus delete(@PathVariable Long id) {
       secondRepository.deleteById(id);
        return HttpStatus.OK;
    }


}