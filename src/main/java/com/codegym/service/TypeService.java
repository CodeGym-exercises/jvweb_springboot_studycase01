package com.codegym.service;

import com.codegym.model.NoteType;
import org.springframework.stereotype.Service;

public interface TypeService {
    NoteType findById(int id);
    Iterable<NoteType> findAll();
    void add(NoteType noteType);
    void delete(int id);
    void save(NoteType noteType);
}
