package com.lab6.controller;

import com.lab6.entity.Specialist;
import com.lab6.service.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/specialists")
@CrossOrigin(origins = "http://localhost:3000")
public class  SpecialistController {

    @Autowired
    private SpecialistService specialistService;

    @GetMapping
    public List<Specialist> getAllSpecialists() {
        return specialistService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Specialist> getSpecialistById(@PathVariable Long id) {
        Specialist specialist = specialistService.findById(id);
        return specialist != null ? ResponseEntity.ok(specialist) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Specialist> createSpecialist(@RequestBody Specialist specialist) {
        Specialist createdSpecialist = specialistService.save(specialist);
        return new ResponseEntity<>(createdSpecialist, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Specialist> updateSpecialist(@PathVariable Long id, @RequestBody Specialist specialist) {
        specialist.setId(id);
        Specialist updatedSpecialist = specialistService.save(specialist);
        return updatedSpecialist != null ? ResponseEntity.ok(updatedSpecialist) : ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecialist(@PathVariable Long id) {
        specialistService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
