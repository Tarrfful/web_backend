package com.lab6.service;

import com.lab6.entity.Owner;
import com.lab6.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }


    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }
}
