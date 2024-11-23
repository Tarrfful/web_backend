package com.lab6.service;

import com.lab6.entity.Specialist;
import com.lab6.entity.Specialization;
import com.lab6.repository.SpecialistRepository;
import com.lab6.repository.SpecializationRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SpecialistService {
    @Autowired
    private SpecialistRepository specialistRepository;

    @Autowired
    private SpecializationRepository specializationRepository;

    public List<Specialist> findAll() {
        return specialistRepository.findAll();
    }

    public Specialist findById(Long id) {
        return specialistRepository.findById(id).orElse(null);
    }

    @Transactional
    public Specialist save(Specialist specialist) {
        Set<Specialization> managedSpecializations = new HashSet<>();

        if (specialist.getSpecializations() != null) {
            for (Specialization spec : specialist.getSpecializations()) {
                // Находим существующую специализацию по ID
                if (spec.getId() != null) { // Проверяем, что ID не null
                    Specialization managedSpec = specializationRepository.findById(spec.getId())
                            .orElseThrow(() -> new EntityNotFoundException("Specialization not found with id: " + spec.getId()));
                    managedSpecializations.add(managedSpec);
                }
            }
        }

        specialist.setSpecializations(managedSpecializations);
        return specialistRepository.save(specialist);
    }

    public void deleteById(Long id) {
        specialistRepository.deleteById(id);
    }

}