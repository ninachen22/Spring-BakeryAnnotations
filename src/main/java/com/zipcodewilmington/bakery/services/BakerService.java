package com.zipcodewilmington.bakery.services;

import com.zipcodewilmington.bakery.models.Baker;
import com.zipcodewilmington.bakery.repositories.BakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BakerService {
    @Autowired
    private BakerRepository bakerRepository;

    public BakerService(BakerRepository repository) {
        this.bakerRepository = repository;
    }

    public Iterable<Baker> index() {
        return bakerRepository.findAll();
    }

    public Baker show(Long id) {
        return bakerRepository.findById(id).get();
    }

    public Baker create(Baker baker) {
        return bakerRepository.save(baker);
    }

    public Baker update(Long id, Baker newBakerData) {
        Baker originalBaker = bakerRepository.findById(id).get();
        originalBaker.setName(newBakerData.getName());
        originalBaker.setSpecialty(newBakerData.getSpecialty());
        return bakerRepository.save(originalBaker);
    }

    public Boolean delete(Long id) {
        bakerRepository.deleteById(id);
        return true;
    }
}
