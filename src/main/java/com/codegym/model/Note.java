package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "Note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "note_type_id")
    private NoteType type;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;

    public Note() {
    }

    public Note(NoteType type, String title, String content) {
        this.type = type;
        this.title = title;
        this.content = content;
    }

    public NoteType getType() {
        return type;
    }

    public void setType(NoteType type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean save(){
        return false;
    }

    public boolean delete(){
        return false;
    }
}
