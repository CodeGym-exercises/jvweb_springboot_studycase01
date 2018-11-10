package com.codegym.service;

import com.codegym.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface NoteService {
    Note findById(int id);
    Iterable<Note> findAll();
    void add(Note note);
    void delete(int id);
    void save(Note note);
    Page<Note> findAll(Pageable pageable);
}
