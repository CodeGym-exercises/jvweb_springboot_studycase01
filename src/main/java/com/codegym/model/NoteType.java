package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "note_type")
public class NoteType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @OneToMany(targetEntity = Note.class)
    private List<Note> notes;

    public NoteType() {
    }

    public int getId() {
        return id;
    }

    public void setIdType(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.isEmpty()||name.equals("")){
            this.name = "NaN";
        }else{
            this.name = name;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Note> getNote() {
        return notes;
    }

    public void setNote(List<Note> note) {
        this.notes = note;
    }
}
