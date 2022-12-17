package com.zipcodewilmington.bakery.services;

import com.zipcodewilmington.bakery.models.Muffin;
import com.zipcodewilmington.bakery.repositories.MuffinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MuffinService {
    @Autowired
    private MuffinRepository muffinRepository;

    public MuffinService(MuffinRepository repository) {
        this.muffinRepository = repository;
    }

    public Iterable<Muffin> index() {
        return muffinRepository.findAll();
    }

    public Muffin show(Long id) {
        return muffinRepository.findById(id).get();
    }

    public Muffin create(Muffin baker) {
        return muffinRepository.save(baker);
    }

    public Muffin update(Long id, Muffin newMuffinData) {
        Muffin originalMuffin = muffinRepository.findById(id).get();
        originalMuffin.setFlavor(newMuffinData.getFlavor());
        return muffinRepository.save(originalMuffin);
    }

    public Boolean delete(Long id) {
        muffinRepository.deleteById(id);
        return true;
    }
}
