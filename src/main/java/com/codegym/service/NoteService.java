package com.codegym.service;

import com.codegym.model.Note;

import java.util.Optional;

public interface NoteService {
    Optional<Note> findById(int id);
    Iterable<Note> findAll();
    void add(Note note);
    void delete(int id);
}
