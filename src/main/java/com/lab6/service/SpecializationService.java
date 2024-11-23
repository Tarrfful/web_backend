package com.lab6.service;

import com.lab6.entity.Specialization;
import com.lab6.repository.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecializationService {

    @Autowired
    private SpecializationRepository specializationRepository;


    public List<Specialization> findAll() {
        return specializationRepository.findAll();
    }


    public Specialization findById(Long id) {
        return specializationRepository.findById(id).orElse(null);
    }


    public Specialization save(Specialization specialization) {
        return specializationRepository.save(specialization);
    }


    public void deleteById(Long id) {
        specializationRepository.deleteById(id);
    }
}