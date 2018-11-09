package com.codegym.service;

import com.codegym.model.Note;
import com.codegym.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class NoteServiceImpl implements NoteService {
    @Autowired
    NoteRepository noteRepository;

    @Override
    public Optional<Note> findById(int id) {
        return noteRepository.findById(id);
    }

    @Override
    public Iterable<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public void add(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void delete(int id) {
        noteRepository.deleteById(id);
    }
}
