package com.lab6.controller;

import com.lab6.entity.Specialization;
import com.lab6.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/specializations")
@CrossOrigin(origins = "http://localhost:3000")
public class SpecializationController {
    @Autowired
    private SpecializationService specializationService;


    @GetMapping
    public List<Specialization> getAllSpecializations() {

        return specializationService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Specialization> getSpecializationById(@PathVariable Long id) {

        Specialization specialization = specializationService.findById(id);
        return specialization != null ? ResponseEntity.ok(specialization) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Specialization> createSpecialization(@RequestBody Specialization specialization) {
        Specialization createdSpecialization = specializationService.save(specialization);
        return new ResponseEntity<>(createdSpecialization, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Specialization> updateSpecialization(@PathVariable Long id, @RequestBody Specialization specialization) {
        specialization.setId(id);
        Specialization updatedSpecialization = specializationService.save(specialization);
        return updatedSpecialization != null ? ResponseEntity.ok(updatedSpecialization) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecialization(@PathVariable Long id) {
        specializationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
