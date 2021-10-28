package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    private NoteListService noteListService;

    public HomeController(NoteListService noteListService) {
        this.noteListService = noteListService;
    }

    @GetMapping()
    public String getHomePage(NoteForm noteForm, Model model) {
        model.addAttribute("greetings", this.noteListService.getNotes());
        return "home";
    }

//    @PostMapping()
//    public String addMessage(MessageForm messageForm, Model model) {
//        messageListService.addMessage(messageForm.getText());
//        model.addAttribute("greetings", messageListService.getMessages());
//        messageForm.setText("");
//        return "home";
//    }

}