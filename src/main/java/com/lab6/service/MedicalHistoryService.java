package com.lab6.service;

import com.lab6.entity.MedicalHistory;
import com.lab6.repository.MedicalHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalHistoryService {

    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;

    public List<MedicalHistory> findAll() {
        return medicalHistoryRepository.findAll();
    }

    public MedicalHistory findById(Long id) {
        return medicalHistoryRepository.findById(id).orElse(null);
    }

    public MedicalHistory save(MedicalHistory medicalHistory) {
        return medicalHistoryRepository.save(medicalHistory);
    }

    public void deleteById(Long id) {
        medicalHistoryRepository.deleteById(id);
    }
}