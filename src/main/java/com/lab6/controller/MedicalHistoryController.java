package com.lab6.controller;

import com.lab6.entity.MedicalHistory;
import com.lab6.service.MedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicalHistories")
@CrossOrigin(origins = "http://localhost:3000")
public class MedicalHistoryController {


    @Autowired
    private MedicalHistoryService medicalHistoryService;

    @GetMapping
    public List<MedicalHistory> getAllMedicalHistories() {
        return medicalHistoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalHistory> getMedicalHistoryById(@PathVariable Long id) {
        MedicalHistory medicalHistory = medicalHistoryService.findById(id);
        return medicalHistory != null ? ResponseEntity.ok(medicalHistory) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<MedicalHistory> createMedicalHistory(@RequestBody MedicalHistory medicalHistory) {

        MedicalHistory createdMedicalHistory = medicalHistoryService.save(medicalHistory);
        return new ResponseEntity<>(createdMedicalHistory, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<MedicalHistory> updateMedicalHistory(@PathVariable Long id, @RequestBody MedicalHistory medicalHistory) {
        medicalHistory.setId(id);

        MedicalHistory updatedMedicalHistory = medicalHistoryService.save(medicalHistory);
        return updatedMedicalHistory != null ? ResponseEntity.ok(updatedMedicalHistory) : ResponseEntity.notFound().build();

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicalHistory(@PathVariable Long id) {

        medicalHistoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
