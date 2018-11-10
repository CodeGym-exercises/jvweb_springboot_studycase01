package com.codegym.service.impl;

import com.codegym.model.NoteType;
import com.codegym.repository.TypeRepository;
import com.codegym.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("TypeService")
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeRepository typeRepository;

    @Override
    public NoteType findById(int id) {
        return typeRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<NoteType> findAll() {
        return typeRepository.findAll();
    }

    @Override
    public void add(NoteType noteType) {
        typeRepository.save(noteType);
    }

    @Override
    public void delete(int id) {
        typeRepository.delete(this.findById(id));
    }

    @Override
    public void save(NoteType noteType) {
        typeRepository.save(noteType);
    }
}
