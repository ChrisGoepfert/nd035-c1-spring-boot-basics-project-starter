package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.constants.Attributes;
import com.udacity.jwdnd.course1.cloudstorage.constants.Templates;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import java.security.Principal;
import java.util.Objects;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@ControllerAdvice
@RequiredArgsConstructor
public class HomeController {

    private final NoteService noteService;
    private final CredentialService credentialService;
    private final FileService fileService;

    @GetMapping("/home")
    public String getHome(Principal principal, Note note, Credential credential, Model model) {
        String username = principal.getName();

        model.addAttribute(Attributes.NOTES, noteService.findNotesByUsername(username));
        model.addAttribute(
                Attributes.CREDENTIALS, credentialService.findCredentialsByUsername(username));
        model.addAttribute(Attributes.FILES, fileService.findFilesByUsername(username));
        return Templates.HOME;
    }


    /*
        NOTES Section
     */
    @PostMapping("/notes")
    public String postNote(Principal principal, Note note, Credential credential, Model model) {
        String username = principal.getName();

        if (Objects.isNull(note.getNoteId())) {
            noteService.createNoteForUser(note, username);
        } else {
            noteService.updateNote(note);
        }

        model.addAttribute(Attributes.SUCCESS, true);

        return Templates.RESULT;
    }

    @DeleteMapping("/notes/{id}")
    public String deleteNote(
            Principal principal,
            @PathVariable("id") String noteId,
            Note note,
            Credential credential,
            Model model) {
        noteService.deleteNote(noteId);

        model.addAttribute(Attributes.SUCCESS, true);

        return Templates.RESULT;
    }


}