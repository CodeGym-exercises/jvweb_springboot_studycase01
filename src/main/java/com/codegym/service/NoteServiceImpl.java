package com.codegym.service;

import com.codegym.model.Note;
import com.codegym.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("NoteService")
public class NoteServiceImpl implements NoteService {
    @Autowired
    NoteRepository noteRepository;

    @Override
    public Note findById(int id) {
        return noteRepository.findById(id).orElse(null);
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

    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }
}
