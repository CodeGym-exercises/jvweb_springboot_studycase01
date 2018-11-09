package com.codegym.service;

import com.codegym.model.Note;

import java.util.Optional;

public interface NoteService {
    Note findById(int id);
    Iterable<Note> findAll();
    void add(Note note);
    void delete(int id);
    void save(Note note);
}
