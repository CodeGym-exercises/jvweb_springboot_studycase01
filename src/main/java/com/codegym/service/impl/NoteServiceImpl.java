package com.codegym.service.impl;

import com.codegym.model.Note;
import com.codegym.repository.NoteRepository;
import com.codegym.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<Note> findAll(Pageable pageable) {
        return noteRepository.findAll(pageable);
    }
}
