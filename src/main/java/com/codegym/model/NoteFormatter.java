package com.codegym.model;

import com.codegym.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class NoteFormatter implements Formatter<Optional<Note>> {
    private NoteService noteService;

    @Autowired
    public NoteFormatter(NoteService noteService){
        this.noteService = noteService;
    }

    @Override
    public Optional<Note> parse(String text, Locale locale) throws ParseException {
        return noteService.findById(Integer.parseInt(text));
    }

    @Override
    public String print(Optional<Note> object, Locale locale) {
        return null;
    }
}
