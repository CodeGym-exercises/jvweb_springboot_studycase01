package com.codegym.controller;

import com.codegym.model.Note;
import com.codegym.service.NoteService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.GeneratedValue;

@Controller
@RequestMapping(value = {"/","/notes"})
public class fController {
    @Autowired
    NoteService noteService;

    @GetMapping
    public ModelAndView showHomePage(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("notes",noteService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public String showCreatePage(Model model){
        model.addAttribute("note",new Note());
        return "create";
    }

    @PostMapping("/create")
    public String addNote(Note note,Model model){
        noteService.add(note);
        //String message ="success";
        model.addAttribute("message","Success!!");
        return "create";
    }

    @GetMapping("/edit/{id}")
    public String showEditPage(){
        return "edit";
    }

    @GetMapping("/delete/{id}")
    public String showDeletePage(@PathVariable int id,Model model){
        model.addAttribute("note", noteService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public ModelAndView deleteNote(@ModelAttribute Note note){
        ModelAndView modelAndView = new ModelAndView("delete");
        noteService.delete(note.getId());
        modelAndView.addObject("message","Delete success!!!");
        return modelAndView;
    }
}
