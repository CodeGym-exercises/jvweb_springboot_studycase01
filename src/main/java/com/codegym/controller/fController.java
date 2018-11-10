package com.codegym.controller;

import com.codegym.model.Note;
import com.codegym.model.NoteType;
import com.codegym.service.NoteService;
import com.codegym.service.TypeService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @Autowired
    TypeService typeService;

    @GetMapping
    public ModelAndView showHomePage(@PageableDefault(size = 3) Pageable pageable){
        Page<Note> notes = noteService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("notes",notes);
        return modelAndView;
    }

    @GetMapping("/create")
    public String showCreatePage(Model model){
        model.addAttribute("note",new Note());
        model.addAttribute("types",typeService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String addNote(Note note,Model model,@RequestParam("type") String type){
        String message = "",status = "";
        if(type.equals("")){
            note.setType(null);
            message = "Fail!! Please enter value to input tag";
            status = "red";
        }else if(!type.equals("")){
            String strFilter = type.replace(",","");
            note.setType(typeService.findById(Integer.parseInt(strFilter)));
            noteService.add(note);
            message = "Success!!!";
            status = "green";
        }

        //String message ="success";
        model.addAttribute("message",message);
        model.addAttribute("status",status);
        return "create";
    }

    @GetMapping("/edit/{id}")
    public String showEditPage(@PathVariable int id, Model model){
        model.addAttribute("note",noteService.findById(id));
        model.addAttribute("types",typeService.findAll());
        return "edit";
    }

    @PostMapping("/edit")
    public ModelAndView editNote(Note note, @RequestParam("type") String type){
        ModelAndView modelAndView = new ModelAndView("edit");
        String message = "", status = "";
        if(type.equals("")){
            message = "Fail!! Please enter value to input tag";
            status = "red";
        }
        else {
            String strFilter = type.substring(type.indexOf(",")+1);
            System.out.printf(strFilter);
            if(!strFilter.equals(note.getType().getId() + "")){
                note.setType(typeService.findById(Integer.parseInt(strFilter)));
            }
            noteService.save(note);
            message = "Edit success!! new id: " + strFilter;
            status = "green";
        }

        modelAndView.addObject("message",message);
        modelAndView.addObject("status",status);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String showDeletePage(@PathVariable int id,Model model){
        model.addAttribute("note", noteService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public ModelAndView deleteNote(@RequestParam("id") int id){
        ModelAndView modelAndView = new ModelAndView("delete");
        Note note = noteService.findById(id);
        noteService.delete(id);
        modelAndView.addObject("note",note);
        modelAndView.addObject("message","Delete success!!!");
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public String showViewPage(@PathVariable int id, Model model){
        model.addAttribute("note",noteService.findById(id));
        return "view";
    }

    //=================================Type note=====================================

    @GetMapping("/createtype")
    public ModelAndView showCreateTypePage(){
        ModelAndView modelAndView = new ModelAndView("createtype");
        modelAndView.addObject("type",new NoteType());
        return modelAndView;
    }

    @PostMapping("/createtype")
    public String createType(NoteType noteType, Model model){
        typeService.add(noteType);
        model.addAttribute("message","Success!!");
        model.addAttribute("type",new NoteType());
        return "createtype";
    }
}
